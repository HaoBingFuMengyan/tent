package com.tent.common.utils;

import org.hibernate.Hibernate;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationUtils {
    public AnnotationUtils() {
    }

    public static void fetchAll(Object obj, boolean ignoreList) {
        if(obj != null) {
            try {
                Method[] rs = obj.getClass().getMethods();
                Method[] var3 = rs;
                int var4 = rs.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    Method r = var3[var5];
                    if(r.getAnnotation(ManyToOne.class) != null) {
                        Hibernate.initialize(r.invoke(obj, new Object[0]));
                    }

                    if(r.getAnnotation(OneToOne.class) != null) {
                        Hibernate.initialize(r.invoke(obj, new Object[0]));
                    }

                    if(!ignoreList) {
                        if(r.getAnnotation(OneToMany.class) != null) {
                            Hibernate.initialize(r.invoke(obj, new Object[0]));
                        }

                        if(r.getAnnotation(ManyToMany.class) != null) {
                            Hibernate.initialize(r.invoke(obj, new Object[0]));
                        }
                    }
                }
            } catch (IllegalAccessException var7) {
                var7.printStackTrace();
            } catch (InvocationTargetException var8) {
                var8.printStackTrace();
            }

        }
    }
}
