package com.tent.common.utils;

import com.tent.common.entity.BaseEntity;
import com.tent.common.exception.E;

import java.util.List;

public class B {

    public B() {
    }

    public static void assertIdNotNUll(BaseEntity obj) {
        if(Y(obj.getId())) {
            E.S("id不能为空", new Object[0]);
        }

    }

    public static void assertNotNUll(Object obj, Object... paras) {
        if(obj instanceof String) {
            if(Y((String)obj)) {
                throwMsg(paras);
            }
        } else if(obj == null) {
            throwMsg(paras);
        }

    }

    private static void throwMsg(Object[] paras) {
        if(paras.length == 0) {
            E.S("不能为空", new Object[0]);
        } else if(paras.length == 1) {
            E.S("%s不能为空", paras);
        } else {
            Object[] rs = new Object[paras.length - 1];

            for(int i = 1; i < paras.length; ++i) {
                rs[i - 1] = paras[i];
            }

            E.S(paras[0].toString(), rs);
        }

    }

    public static boolean Y(String obj) {
        return StringUtils.isBlank(obj);
    }

    public static boolean N(String obj) {
        return StringUtils.isNotBlank(obj);
    }

    public static boolean Y(String[] list) {
        return null == list || list.length == 0;
    }

    public static boolean N(String[] list) {
        return null != list && list.length != 0;
    }

    public static boolean Y(List list) {
        return null == list || list.size() == 0;
    }

    public static boolean N(List list) {
        return null != list && list.size() != 0;
    }

    public static boolean contains(String[] array, String value) {
        if(array != null && array.length != 0) {
            String[] var2 = array;
            int var3 = array.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String str = var2[var4];
                if(str.equals(value)) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static boolean equals(String a, String b) {
        return !Y(a) && !Y(b)?a.equals(b):false;
    }
}
