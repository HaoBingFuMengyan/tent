package com.tent.common.utils;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.List;

public class S {

    public S(){}

    public static String redirect(String url){
        return "redirect:/" + url;
    }

    public static String toPage(String pageUrl){
        return pageUrl;
    }

    public static Predicate andList(CriteriaBuilder cb, List<Predicate> list) {
        return cb.and((Predicate[])list.toArray(new Predicate[list.size()]));
    }
}
