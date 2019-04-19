package com.tent.cloud.hy;

import com.tent.po.entity.hy.User;
import com.tent.service.impl.hy.UserService;
import com.tent.service.inte.hy.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value = "/member/")
public class MemberAction {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "index.shtml")
    public String memberIndex(Model model, HttpServletRequest request){
        return "member/index";
    }

}
