package com.tent.common.jpa;

import java.io.Serializable;

public class Ajax implements Serializable {

    private static final int AJAX_FAILURE = 101;//失败错误码

    private boolean success=true;

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String msg;

    /**
     * 返回内容
     */
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public Ajax(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = "";
    }

    public Ajax(boolean success, int code, String msg, Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Ajax success(Object content,String msg){
        return new Ajax(true,200,msg,content);
    }

    public static Ajax success(Object content){
        return new Ajax(true,200,"",content);
    }

    public static Ajax success(String message){
        return new Ajax(true,200,"");
    }

    public static Ajax failure(String msg){
        return new Ajax(false,Ajax.AJAX_FAILURE,msg);
    }

    public static Ajax failure(){
        return new Ajax(false,Ajax.AJAX_FAILURE,"");
    }
}
