package com.tent.cloud.web.main;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class OfficeAction {

    @RequestMapping(value = "index.shtml", method = RequestMethod.GET)
    @RequiresPermissions("admin:manage")
//    @RequiresRoles("admin")
    public String index(Model model, HttpServletRequest request) {
        return "of/member-index";
    }

}
