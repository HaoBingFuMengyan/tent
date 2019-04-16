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
        System.out.println("登陆成功");
        return "member/index";
    }

    @RequestMapping(value = "add.html")
    public void addUser(HttpServletRequest request,Model model){
        User obj = new User();
        obj.setId(null);
        obj.setNickname("123");
        obj.setEmail("123");
        obj.setPswd("23456");
        obj.setCreateTime(new Date());
        obj.setLastLoginTime(new Date());
        obj.setStatus(1);

        User user = userService.insert(obj);

    }
}
