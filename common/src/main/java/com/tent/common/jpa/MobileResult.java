package com.tent.common.jpa;

import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;

public class MobileResult implements Serializable{

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

    public MobileResult put(String key,Object obj){
        if(data == null || data instanceof String){
            data= Maps.newHashMap();
        }
        if(data instanceof Map){
            ((Map)data).put(key, obj);
        }
        return this;
    }

    public MobileResult putAll(Map<String,Object> map){
        if(data == null || data instanceof String){
            data= Maps.newHashMap();
        }
        if(data instanceof Map){
            ((Map)data).putAll(map);
        }
        return this;
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

    public boolean isSuccess() {
        return success;
    }

    public MobileResult(boolean success,int code, String message) {
        this.code = code;
        this.msg = message;
        this.success=success;
        this.data = "";
    }

    public MobileResult(boolean success,int code, String message, Object content) {
        this.code = code;
        this.msg = message;
        this.success=success;
        this.data = content;
    }

    public MobileResult(){
        super();
    }

    public MobileResult(ResultStatus status) {
        this.code = status.getCode();
        this.msg = status.getMessage();
        if(status.getCode() != 0)
            this.success=false;
        this.data = "";
    }



    public MobileResult(ResultStatus status, Object content) {
        this.code = status.getCode();
        this.msg = status.getMessage();
        if(status.getCode() != 0)
            this.success=false;
        this.data = content;
    }

    public static MobileResult ok(Object content) {
        return new MobileResult(ResultStatus.SUCCESS, content);
    }

    public static MobileResult ok() {
        return new MobileResult(ResultStatus.SUCCESS);
    }

    public static MobileResult error(ResultStatus error) {
        return new MobileResult(error);
    }


    /**
     * service 异常
     * @param message
     * @return
     */
    public static MobileResult error(String message) {
        return new MobileResult(false,ResultStatus.service_exception.getCode(),message,null);
    }

    public static MobileResult error(String message,Object content) {
        return new MobileResult(false,ResultStatus.service_exception.getCode(),message,content);
    }

    public static MobileResult failure(String message) {
        return new MobileResult(false,ResultStatus.service_exception.getCode(),message,null);
    }

    public static MobileResult failure(String message,Object content) {
        return new MobileResult(false,ResultStatus.service_exception.getCode(),message,content);
    }
}
