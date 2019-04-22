package com.tent.cloud.sp;

import com.tent.common.utils.S;
import com.tent.common.web.Msg;
import com.tent.po.entity.sp.Category;
import com.tent.service.inte.sp.ICategoryService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/category/")
public class CategoryAction {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "list.shtml",method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, HttpSession session){
        try {

            Page<Category> list = this.categoryService.findPageList(null);

            model.addAttribute("list",list);
        }catch (ServiceException ex){
            ex.printStackTrace();
            Msg.error(model,ex.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            Msg.error(model,e.getMessage());
        }
        return S.toPage("category/list");
    }

}
