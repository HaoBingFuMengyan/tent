package com.tent.cloud.hy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class PageAction {

    @GetMapping(value = "index.html")
    public String index(Model model){
        model.addAttribute("msg","你好spring mvc");
        return "index";
    }


    @RequestMapping(value = "login.json")
    @ResponseBody
    public String memberLogin(@RequestParam(value = "sname",required = true) String sname,
                              @RequestParam(value = "spassword",required = true) String spassword,
                              @RequestParam(value = "checkcode",required = true) String checkcode, Model model, HttpServletRequest request){

        System.out.println("sname:"+sname+",spassword:"+spassword+",checkcode:"+checkcode);
        return "success";
    }

}
