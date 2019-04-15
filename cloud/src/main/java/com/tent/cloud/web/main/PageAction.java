package com.tent.cloud.web.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")
public class PageAction {

    @RequestMapping(value = "index.html",method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("msg","你好spring mvc");
        return "page/index";
    }

}
