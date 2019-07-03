package com.tent.common.entity;


import com.google.common.collect.Maps;

import java.util.Map;

public class IConstUtils {
    public IConstUtils() {
    }

    public static Map<Integer, String> map(IConst[] cs) {
        Map<Integer, String> m = Maps.newLinkedHashMap();
        IConst[] var2 = cs;
        int var3 = cs.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            IConst c = var2[var4];
            m.put(Integer.valueOf(c.val()), c.label());
        }

        return m;
    }

    public static Map<String, String> smap(IConst[] cs) {
        Map<String, String> m = Maps.newLinkedHashMap();
        IConst[] var2 = cs;
        int var3 = cs.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            IConst c = var2[var4];
            m.put(String.valueOf(c.val()), c.label());
        }

        return m;
    }

}
