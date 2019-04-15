package com.tent.common.exception;


import org.hibernate.service.spi.ServiceException;

public class E {

    public E() {
    }

    public static void S(String obj, Object... para) {
        if(obj.length() > 0) {
            obj = String.format(obj, para);
        }

        throw new ServiceException(obj);
    }

    public static String getDetail(Exception e) {
        StringBuffer msg = new StringBuffer("null");
        if(e != null) {
            msg = new StringBuffer("");
            String message = e.toString();
            int length = e.getStackTrace().length;
            if(length > 0) {
                msg.append(message + "\n");

                for(int i = 0; i < length; ++i) {
                    msg.append("\t" + e.getStackTrace()[i] + "\n");
                }
            } else {
                msg.append(message);
            }
        }

        return msg.toString();
    }

    public static void Box(String obj) {
        throw new ServiceException(obj);
    }
}
