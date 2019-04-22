package com.tent.cloud.sp;

import com.tent.common.jpa.Result;
import com.tent.common.utils.S;
import com.tent.po.entity.sp.Category;
import com.tent.service.inte.sp.ICategoryService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/category/")
public class CategoryAction {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "list.shtml",method = RequestMethod.GET)
    public String list(Model model,HttpServletRequest request,HttpSession session){
        return S.toPage("category/list");
    }

    @RequestMapping(value = "list.json")
    @ResponseBody
    public Result index(Model model, HttpServletRequest request, HttpSession session){
        try {

            Page<Category> list = this.categoryService.findPageList(null);

            return  Result.success(list,"");
        }catch (ServiceException ex){
            ex.printStackTrace();
            return Result.failure(ex.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return Result.failure(e.getMessage());
        }
    }

    @RequestMapping(value = "add.shtml",method = RequestMethod.GET)
    public String add(Model model,HttpServletRequest request,HttpSession session){
        return S.toPage("category/add");
    }

    @RequestMapping(value = "add.shtml",method = RequestMethod.POST)
    public String add(Category category, Model model,HttpServletRequest request,HttpSession session){
        try {

        }catch (ServiceException ex){
            ex.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return "";
    }

}
