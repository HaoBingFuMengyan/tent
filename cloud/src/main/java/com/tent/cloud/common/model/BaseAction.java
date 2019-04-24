package com.tent.cloud.common.model;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class BaseAction {

    public BaseAction() {
    }

    @ModelAttribute
    public void dataModel(@RequestParam(value = "id") String id, Model model){

    }
}
