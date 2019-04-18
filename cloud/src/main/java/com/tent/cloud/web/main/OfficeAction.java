package com.tent.cloud.web.main;

import com.tent.common.utils.S;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
    public String index(Model model, HttpServletRequest request) {
        return S.toPage("of/index");
    }

}
