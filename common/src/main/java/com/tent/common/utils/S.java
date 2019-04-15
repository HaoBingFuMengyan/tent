package com.tent.common.utils;


public class S {

    public S(){}

    public static String redirect(String url){
        return "redirect:/" + url;
    }

    public static String toPage(String pageUrl){
        return pageUrl;
    }
}
