package com.tent.cloud.hy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageAction {

    @RequestMapping(value = "/index.html")
    public String index(Model model){
        model.addAttribute("msg","你好spring mvc");
        System.out.println("jinrul _________====");
        return "index";
    }

}
