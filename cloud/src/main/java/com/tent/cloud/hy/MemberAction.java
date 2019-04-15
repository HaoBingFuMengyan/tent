package com.tent.cloud.hy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/member/")
public class MemberAction {

    @RequestMapping(value = "index.shtml")
    public String memberIndex(Model model, HttpServletRequest request){
        System.out.println("登陆成功");
        return "member/index";
    }
}
