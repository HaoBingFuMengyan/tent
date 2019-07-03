package com.tent.common.json;

import com.tent.common.exception.E;
import net.sf.json.JSONString;
import net.sf.json.util.JSONTokener;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class JSONObject implements Map<String, Object> {

    private int level;
    private Map map;
    public static final Object NULL = new JSONObject.Null();

    public JSONObject() {
        this.level = 0;
        this.map = new HashMap();
    }

    public Map getMap() {
        return this.map;
    }

    public JSONObject(JSONObject jo, String[] names) {
        this();

        for(int i = 0; i < names.length; ++i) {
            try {
                this.putOnce(names[i], jo.opt(names[i]));
            } catch (Exception var5) {
                ;
            }
        }

    }

    public JSONObject(JSONTokener x) throws JSONException {
        this();
        if(x.nextClean() != 123) {
            throw x.syntaxError("A JSONObject text must begin with '{'");
        } else {
            while(true) {
                char c = x.nextClean();
                switch(c) {
                    case '\u0000':
                        throw x.syntaxError("A JSONObject text must end with '}'");
                    case '}':
                        return;
                    default:
                        x.back();
                        String key = x.nextValue().toString();
                        c = x.nextClean();
                        if(c == 61) {
                            if(x.next() != 62) {
                                x.back();
                            }
                        } else if(c != 58) {
                            throw x.syntaxError("Expected a ':' after a key");
                        }

                        this.putOnce(key, x.nextValue());
                        switch(x.nextClean()) {
                            case ',':
                            case ';':
                                if(x.nextClean() == 125) {
                                    return;
                                }

                                x.back();
                                break;
                            case '}':
                                return;
                            default:
                                throw x.syntaxError("Expected a ',' or '}'");
                        }
                }
            }
        }
    }

    public JSONObject(Map map, int... levels) {
        this.level = 0;
        if(levels.length == 1) {
            this.level = levels[0];
        }

        this.map = new HashMap();
        if(map != null) {
            Iterator i = map.entrySet().iterator();

            while(i.hasNext()) {
                Entry e = (Entry)i.next();
                Object value = e.getValue();
                if(value != null) {
                    this.map.put(e.getKey(), wrap(value, new int[]{this.level}));
                }
            }
        }

    }

    public JSONObject(Object bean, int... levels) {
        this();
        if(levels.length == 1) {
            this.level = levels[0];
        }

        this.populateMap(bean, this.level);
    }

    public JSONObject(Object object, String[] names) {
        this();
        Class c = object.getClass();

        for(int i = 0; i < names.length; ++i) {
            String name = names[i];

            try {
                this.putOpt(name, c.getField(name).get(object));
            } catch (Exception var7) {
                ;
            }
        }

    }

    public JSONObject(String source) throws JSONException {
        this(new JSONTokener(source));
    }

    public JSONObject(String baseName, Locale locale) throws JSONException {
        this();
        ResourceBundle r = ResourceBundle.getBundle(baseName, locale, Thread.currentThread().getContextClassLoader());
        Enumeration keys = r.getKeys();

        while(true) {
            Object key;
            do {
                if(!keys.hasMoreElements()) {
                    return;
                }

                key = keys.nextElement();
            } while(!(key instanceof String));

            String[] path = ((String)key).split("\\.");
            int last = path.length - 1;
            JSONObject target = this;

            for(int i = 0; i < last; ++i) {
                String segment = path[i];
                JSONObject nextTarget = target.optJSONObject(segment);
                if(nextTarget == null) {
                    nextTarget = new JSONObject();
                    target.put((String)segment, (Map)nextTarget);
                }

                target = nextTarget;
            }

            target.put((String)path[last], (Object)r.getString((String)key));
        }
    }

    public JSONObject accumulate(String key, Object value) throws JSONException {
        testValidity(value);
        Object object = this.opt(key);
        if(object == null) {
            this.put(key, value instanceof JSONArray ?(new JSONArray()).put(value):value);
        } else if(object instanceof JSONArray) {
            ((JSONArray)object).put(value);
        } else {
            this.put((String)key, (Collection)(new JSONArray()).put(object).put(value));
        }

        return this;
    }

    public JSONObject append(String key, Object value) throws JSONException {
        testValidity(value);
        Object object = this.opt(key);
        if(object == null) {
            this.put((String)key, (Collection)(new JSONArray()).put(value));
        } else {
            if(!(object instanceof JSONArray)) {
                throw new JSONException("JSONObject[" + key + "] is not a JSONArray.");
            }

            this.put((String)key, (Collection)((JSONArray)object).put(value));
        }

        return this;
    }

    public static String doubleToString(double d) {
        if(!Double.isInfinite(d) && !Double.isNaN(d)) {
            String string = Double.toString(d);
            if(string.indexOf(46) > 0 && string.indexOf(101) < 0 && string.indexOf(69) < 0) {
                while(string.endsWith("0")) {
                    string = string.substring(0, string.length() - 1);
                }

                if(string.endsWith(".")) {
                    string = string.substring(0, string.length() - 1);
                }
            }

            return string;
        } else {
            return "null";
        }
    }

    public Object get(String key) throws JSONException {
        if(key == null) {
            throw new JSONException("Null key.");
        } else {
            Object object = this.opt(key);
            if(object == null) {
                throw new JSONException("JSONObject[" + quote(key) + "] not found.");
            } else {
                return object;
            }
        }
    }

    public boolean getBoolean(String key) throws JSONException {
        Object object = this.get(key);
        if(!object.equals(Boolean.FALSE) && (!(object instanceof String) || !((String)object).equalsIgnoreCase("false"))) {
            if(!object.equals(Boolean.TRUE) && (!(object instanceof String) || !((String)object).equalsIgnoreCase("true"))) {
                throw new JSONException("JSONObject[" + quote(key) + "] is not a Boolean.");
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public double getDouble(String key) throws JSONException {
        Object object = this.get(key);

        try {
            return object instanceof Number?((Number)object).doubleValue():Double.parseDouble((String)object);
        } catch (Exception var4) {
            throw new JSONException("JSONObject[" + quote(key) + "] is not a number.");
        }
    }

    public int getInt(String key) throws JSONException {
        Object object = this.get(key);

        try {
            return object instanceof Number?((Number)object).intValue():Integer.parseInt((String)object);
        } catch (Exception var4) {
            throw new JSONException("JSONObject[" + quote(key) + "] is not an int.");
        }
    }

    public JSONArray getJSONArray(String key) throws JSONException {
        Object object = this.get(key);
        if(object instanceof JSONArray) {
            return (JSONArray)object;
        } else {
            throw new JSONException("JSONObject[" + quote(key) + "] is not a JSONArray.");
        }
    }

    public JSONObject getJSONObject(String key) throws JSONException {
        Object object = this.get(key);
        if(object instanceof JSONObject) {
            return (JSONObject)object;
        } else {
            throw new JSONException("JSONObject[" + quote(key) + "] is not a JSONObject.");
        }
    }

    public long getLong(String key) throws JSONException {
        Object object = this.get(key);

        try {
            return object instanceof Number?((Number)object).longValue():Long.parseLong((String)object);
        } catch (Exception var4) {
            throw new JSONException("JSONObject[" + quote(key) + "] is not a long.");
        }
    }

    public static String[] getNames(JSONObject jo) {
        int length = jo.length();
        if(length == 0) {
            return null;
        } else {
            Iterator iterator = jo.keys();
            String[] names = new String[length];

            for(int i = 0; iterator.hasNext(); ++i) {
                names[i] = (String)iterator.next();
            }

            return names;
        }
    }

    public static String[] getNames(Object object) {
        if(object == null) {
            return null;
        } else {
            Class klass = object.getClass();
            Field[] fields = klass.getFields();
            int length = fields.length;
            if(length == 0) {
                return null;
            } else {
                String[] names = new String[length];

                for(int i = 0; i < length; ++i) {
                    names[i] = fields[i].getName();
                }

                return names;
            }
        }
    }

    public String getString(String key) throws JSONException {
        Object object = this.get(key);
        return object == NULL?null:object.toString();
    }

    public boolean has(String key) {
        return this.map.containsKey(key);
    }

    public JSONObject increment(String key) throws JSONException {
        Object value = this.opt(key);
        if(value == null) {
            this.put(key, 1);
        } else if(value instanceof Integer) {
            this.put(key, ((Integer)value).intValue() + 1);
        } else if(value instanceof Long) {
            this.put(key, ((Long)value).longValue() + 1L);
        } else if(value instanceof Double) {
            this.put(key, ((Double)value).doubleValue() + 1.0D);
        } else {
            if(!(value instanceof Float)) {
                throw new JSONException("Unable to increment [" + quote(key) + "].");
            }

            this.put(key, (double)(((Float)value).floatValue() + 1.0F));
        }

        return this;
    }

    public boolean isNull(String key) {
        return NULL.equals(this.opt(key));
    }

    public Iterator keys() {
        return this.map.keySet().iterator();
    }

    public int length() {
        return this.map.size();
    }

    public JSONArray names() {
        JSONArray ja = new JSONArray();
        Iterator keys = this.keys();

        while(keys.hasNext()) {
            ja.put(keys.next());
        }

        return ja.length() == 0?null:ja;
    }

    public static String numberToString(Number number) throws JSONException {
        if(number == null) {
            throw new JSONException("Null pointer");
        } else {
            testValidity(number);
            String string = number.toString();
            if(string.indexOf(46) > 0 && string.indexOf(101) < 0 && string.indexOf(69) < 0) {
                while(string.endsWith("0")) {
                    string = string.substring(0, string.length() - 1);
                }

                if(string.endsWith(".")) {
                    string = string.substring(0, string.length() - 1);
                }
            }

            return string;
        }
    }

    public Object opt(String key) {
        return key == null?null:this.map.get(key);
    }

    public boolean optBoolean(String key) {
        return this.optBoolean(key, false);
    }

    public boolean optBoolean(String key, boolean defaultValue) {
        try {
            return this.getBoolean(key);
        } catch (Exception var4) {
            return defaultValue;
        }
    }

    public double optDouble(String key) {
        return this.optDouble(key, 0.0D / 0.0);
    }

    public double optDouble(String key, double defaultValue) {
        try {
            return this.getDouble(key);
        } catch (Exception var5) {
            return defaultValue;
        }
    }

    public int optInt(String key) {
        return this.optInt(key, 0);
    }

    public int optInt(String key, int defaultValue) {
        try {
            return this.getInt(key);
        } catch (Exception var4) {
            return defaultValue;
        }
    }

    public JSONArray optJSONArray(String key) {
        Object o = this.opt(key);
        return o instanceof JSONArray?(JSONArray)o:null;
    }

    public JSONObject optJSONObject(String key) {
        Object object = this.opt(key);
        return object instanceof JSONObject?(JSONObject)object:null;
    }

    public long optLong(String key) {
        return this.optLong(key, 0L);
    }

    public long optLong(String key, long defaultValue) {
        try {
            return this.getLong(key);
        } catch (Exception var5) {
            return defaultValue;
        }
    }

    public String optString(String key) {
        return this.optString(key, "");
    }

    public String optString(String key, String defaultValue) {
        Object object = this.opt(key);
        return NULL.equals(object)?defaultValue:object.toString();
    }

    private void populateMap(Object bean, int level) {
        Class klass = bean.getClass();
        if(level >= 0) {
            boolean includeSuperClass = klass.getClassLoader() != null;
            Method[] methods = includeSuperClass?klass.getMethods():klass.getDeclaredMethods();

            for(int i = 0; i < methods.length; ++i) {
                try {
                    Method method = methods[i];
                    if(Modifier.isPublic(method.getModifiers())) {
                        String name = method.getName();
                        String key = "";
                        if(name.startsWith("get")) {
                            if(!name.equals("getClass") && !name.equals("getDeclaringClass")) {
                                key = name.substring(3);
                            } else {
                                key = "";
                            }
                        } else if(name.startsWith("is")) {
                            key = name.substring(2);
                        }

                        if(key.length() > 0 && Character.isUpperCase(key.charAt(0)) && method.getParameterTypes().length == 0) {
                            if(key.length() == 1) {
                                key = key.toLowerCase();
                            } else if(!Character.isUpperCase(key.charAt(1))) {
                                key = key.substring(0, 1).toLowerCase() + key.substring(1);
                            }

                            Class<?> cls = method.getReturnType();
                            Object result;
                            if(!cls.isPrimitive() && !Number.class.isAssignableFrom(cls) && !Date.class.isAssignableFrom(cls) && !String.class.isAssignableFrom(cls) && !Boolean.class.isAssignableFrom(cls)) {
                                if(level != 0) {
                                    result = method.invoke(bean, (Object[])null);
                                    this.map.put(key, wrap(result, new int[]{level - 1}));
                                }
                            } else {
                                result = method.invoke(bean, (Object[])null);
                                if(result != null) {
                                    this.map.put(key, result);
                                } else {
                                    this.map.put(key, NULL);
                                }
                            }
                        }
                    }
                } catch (Exception var12) {
                    ;
                }
            }

        }
    }

    public JSONObject put(String key, boolean value) throws JSONException {
        this.put((String)key, (Object)(value?Boolean.TRUE:Boolean.FALSE));
        return this;
    }

    public JSONObject put(String key, Collection value) throws JSONException {
        this.put((String)key, (Collection)(new JSONArray(value)));
        return this;
    }

    public JSONObject put(String key, double value) throws JSONException {
        this.put((String)key, (Object)(new Double(value)));
        return this;
    }

    public JSONObject put(String key, int value) throws JSONException {
        this.put((String)key, (Object)(new Integer(value)));
        return this;
    }

    public JSONObject put(String key, long value) throws JSONException {
        this.put((String)key, (Object)(new Long(value)));
        return this;
    }

    public JSONObject put(String key, Map value) throws JSONException {
        this.put((String)key, (Map)(new JSONObject(value, new int[0])));
        return this;
    }

    public JSONObject put(String key, Object value) {
        if(key == null) {
            E.S("Null key.", new Object[0]);
        }

        if(value != null) {
            try {
                testValidity(value);
            } catch (JSONException var4) {
                E.S(var4.getMessage(), new Object[0]);
            }

            this.map.put(key, value);
        } else {
            this.remove(key);
        }

        return this;
    }

    public JSONObject putOnce(String key, Object value) throws JSONException {
        if(key != null && value != null) {
            if(this.opt(key) != null) {
                throw new JSONException("Duplicate key \"" + key + "\"");
            }

            this.put(key, value);
        }

        return this;
    }

    public JSONObject putOpt(String key, Object value) throws JSONException {
        if(key != null && value != null) {
            this.put(key, value);
        }

        return this;
    }

    public static String quote(String string) {
        if(string != null && string.length() != 0) {
            char c = 0;
            int len = string.length();
            StringBuffer sb = new StringBuffer(len + 4);
            sb.append('"');

            for(int i = 0; i < len; ++i) {
                char b = c;
                c = string.charAt(i);
                switch(c) {
                    case '\b':
                        sb.append("\\b");
                        continue;
                    case '\t':
                        sb.append("\\t");
                        continue;
                    case '\n':
                        sb.append("\\n");
                        continue;
                    case '\f':
                        sb.append("\\f");
                        continue;
                    case '\r':
                        sb.append("\\r");
                        continue;
                    case '"':
                    case '\\':
                        sb.append('\\');
                        sb.append(c);
                        continue;
                    case '/':
                        if(b == 60) {
                            sb.append('\\');
                        }

                        sb.append(c);
                        continue;
                }

                if(c >= 32 && (c < 128 || c >= 160) && (c < 8192 || c >= 8448)) {
                    sb.append(c);
                } else {
                    String hhhh = "000" + Integer.toHexString(c);
                    sb.append("\\u" + hhhh.substring(hhhh.length() - 4));
                }
            }

            sb.append('"');
            return sb.toString();
        } else {
            return "\"\"";
        }
    }

    public Object remove(String key) {
        return this.map.remove(key);
    }

    public Iterator sortedKeys() {
        return (new TreeSet(this.map.keySet())).iterator();
    }

    public static Object stringToValue(String string) {
        if(string.equals("")) {
            return string;
        } else if(string.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        } else if(string.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        } else if(string.equalsIgnoreCase("null")) {
            return NULL;
        } else {
            char b = string.charAt(0);
            if(b >= 48 && b <= 57 || b == 46 || b == 45 || b == 43) {
                if(b == 48 && string.length() > 2 && (string.charAt(1) == 120 || string.charAt(1) == 88)) {
                    try {
                        return new Integer(Integer.parseInt(string.substring(2), 16));
                    } catch (Exception var4) {
                        ;
                    }
                }

                try {
                    if(string.indexOf(46) <= -1 && string.indexOf(101) <= -1 && string.indexOf(69) <= -1) {
                        Long myLong = new Long(string);
                        if(myLong.longValue() == (long)myLong.intValue()) {
                            return new Integer(myLong.intValue());
                        }

                        return myLong;
                    }

                    return Double.valueOf(string);
                } catch (Exception var3) {
                    ;
                }
            }

            return string;
        }
    }

    public static void testValidity(Object o) throws JSONException {
        if(o != null) {
            if(o instanceof Double) {
                if(((Double)o).isInfinite() || ((Double)o).isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            } else if(o instanceof Float && (((Float)o).isInfinite() || ((Float)o).isNaN())) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        }

    }

    public JSONArray toJSONArray(JSONArray names) throws JSONException {
        if(names != null && names.length() != 0) {
            JSONArray ja = new JSONArray();

            for(int i = 0; i < names.length(); ++i) {
                ja.put(this.opt(names.getString(i)));
            }

            return ja;
        } else {
            return null;
        }
    }

    public String toString() {
        try {
            Iterator keys = this.keys();
            StringBuffer sb = new StringBuffer("{");

            while(keys.hasNext()) {
                if(sb.length() > 1) {
                    sb.append(',');
                }

                Object o = keys.next();
                sb.append(quote(o.toString()));
                sb.append(':');
                sb.append(valueToString(this.map.get(o)));
            }

            sb.append('}');
            return sb.toString();
        } catch (Exception var4) {
            return null;
        }
    }

    public String toString(int indentFactor) throws JSONException {
        return this.toString(indentFactor, 0);
    }

    String toString(int indentFactor, int indent) throws JSONException {
        int length = this.length();
        if(length == 0) {
            return "{}";
        } else {
            Iterator keys = this.sortedKeys();
            int newindent = indent + indentFactor;
            StringBuffer sb = new StringBuffer("{");
            Object object;
            if(length == 1) {
                object = keys.next();
                sb.append(quote(object.toString()));
                sb.append(": ");
                sb.append(valueToString(this.map.get(object), indentFactor, indent));
            } else {
                while(true) {
                    int i;
                    if(!keys.hasNext()) {
                        if(sb.length() > 1) {
                            sb.append('\n');

                            for(i = 0; i < indent; ++i) {
                                sb.append(' ');
                            }
                        }
                        break;
                    }

                    object = keys.next();
                    if(sb.length() > 1) {
                        sb.append(",\n");
                    } else {
                        sb.append('\n');
                    }

                    for(i = 0; i < newindent; ++i) {
                        sb.append(' ');
                    }

                    sb.append(quote(object.toString()));
                    sb.append(": ");
                    sb.append(valueToString(this.map.get(object), indentFactor, newindent));
                }
            }

            sb.append('}');
            return sb.toString();
        }
    }

    public static String valueToString(Object value) throws JSONException {
        if(value != null && !value.equals((Object)null)) {
            if(value instanceof JSONString) {
                String object;
                try {
                    object = ((JSONString)value).toJSONString();
                } catch (Exception var3) {
                    throw new JSONException(var3);
                }

                if(object instanceof String) {
                    return (String)object;
                } else {
                    throw new JSONException("Bad value from toJSONString: " + object);
                }
            } else {
                return value instanceof Number?numberToString((Number)value):(!(value instanceof Boolean) && !(value instanceof JSONObject) && !(value instanceof JSONArray)?(value instanceof Map?(new JSONObject((Map)value, new int[0])).toString():(value instanceof Collection?(new JSONArray((Collection)value)).toString():(value.getClass().isArray()?(new JSONArray(value)).toString():quote(value.toString())))):value.toString());
            }
        } else {
            return "null";
        }
    }

    static String valueToString(Object value, int indentFactor, int indent) throws JSONException {
        if(value != null && !value.equals((Object)null)) {
            try {
                if(value instanceof JSONString) {
                    Object o = ((JSONString)value).toJSONString();
                    if(o instanceof String) {
                        return (String)o;
                    }
                }
            } catch (Exception var4) {
                ;
            }

            return value instanceof Number?numberToString((Number)value):(value instanceof Boolean?value.toString():(value instanceof JSONObject?((JSONObject)value).toString(indentFactor, indent):(value instanceof JSONArray?((JSONArray)value).toString(indentFactor, indent):(value instanceof Map?(new JSONObject((Map)value, new int[0])).toString(indentFactor, indent):(value instanceof Collection?(new JSONArray((Collection)value)).toString(indentFactor, indent):(value.getClass().isArray()?(new JSONArray(value)).toString(indentFactor, indent):quote(value.toString())))))));
        } else {
            return "null";
        }
    }

    public static Object wrap(Object object, int... levels) {
        int level;
        if(levels.length == 0) {
            level = 0;
        } else {
            level = levels[0];
        }

        if(level < 0) {
            return null;
        } else {
            try {
                if(object == null) {
                    return NULL;
                } else if(!(object instanceof JSONObject) && !(object instanceof JSONArray) && !NULL.equals(object) && !(object instanceof JSONString) && !(object instanceof Byte) && !(object instanceof Character) && !(object instanceof Short) && !(object instanceof Integer) && !(object instanceof Long) && !(object instanceof Boolean) && !(object instanceof Float) && !(object instanceof Double) && !(object instanceof String)) {
                    if(object instanceof Collection) {
                        return new JSONArray((Collection)object, level);
                    } else if(object.getClass().isArray()) {
                        return new JSONArray(object, level);
                    } else if(object instanceof Map) {
                        return new JSONObject((Map)object, new int[]{level});
                    } else {
                        Package objectPackage = object.getClass().getPackage();
                        String objectPackageName = objectPackage != null?objectPackage.getName():"";
                        return !objectPackageName.startsWith("java.") && !objectPackageName.startsWith("javax.") && object.getClass().getClassLoader() != null?new JSONObject(object, new int[]{level}):object.toString();
                    }
                } else {
                    return object;
                }
            } catch (Exception var5) {
                return null;
            }
        }
    }

    public Writer write(Writer writer) throws JSONException {
        try {
            boolean commanate = false;
            Iterator keys = this.keys();
            writer.write(123);

            for(; keys.hasNext(); commanate = true) {
                if(commanate) {
                    writer.write(44);
                }

                Object key = keys.next();
                writer.write(quote(key.toString()));
                writer.write(58);
                Object value = this.map.get(key);
                if(value instanceof JSONObject) {
                    ((JSONObject)value).write(writer);
                } else if(value instanceof JSONArray) {
                    ((JSONArray)value).write(writer);
                } else {
                    writer.write(valueToString(value));
                }
            }

            writer.write(125);
            return writer;
        } catch (IOException var6) {
            throw new JSONException(var6);
        }
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    public Object get(Object key) {
        return this.map.get(key);
    }

    public Object remove(Object key) {
        return this.map.remove(key);
    }

    public void putAll(Map<? extends String, ? extends Object> m) {
        this.map.putAll(m);
    }

    public void clear() {
        this.map.clear();
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    public Collection<Object> values() {
        return this.map.values();
    }

    public Set<Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    public static <T> Object toBean(JSONObject jo, Class<T> cls) {
        Iterator<String> it = jo.keys();
        Object obj = null;

        try {
            obj = Class.forName(cls.getName()).newInstance();
        } catch (Exception var7) {
            ;
        }

        while(it.hasNext()) {
            try {
                String name = (String)it.next();
                Object o = jo.opt(name);
                BeanUtils.setProperty(obj, name, o);
            } catch (Exception var6) {
                var6.printStackTrace();
            }
        }

        return obj;
    }

    private static final class Null {
        private Null() {
        }

        protected final Object clone() {
            return this;
        }

        public boolean equals(Object object) {
            return object == null || object == this;
        }

        public String toString() {
            return "null";
        }
    }
}
