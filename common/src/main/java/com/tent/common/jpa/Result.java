package com.tent.common.jpa;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable{

    private Integer code;
    private String msg = "";
    private long count = 0L;
    private List<?> data;

    public static Result success(Page<?> p,String message) {
        return new Result(p,message);
    }

    public static Result success(String message) {
        return new Result(message);
    }

    public static Result failure(String message) {
        return new Result(message);
    }

    public Result(){

    }

    public Result(Page<?> p,String message){
        this.data = p.getContent();
        this.count = p.getTotalElements();
        this.code = 0;
        if (count == 0L)
            this.msg = "抱歉，没有加载到任何数据";
        else
            this.msg = message;
    }

    public Result(String message){
        this.msg = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public long getCount() {
        return count;
    }

    public List<?> getData() {
        return data;
    }
}
