package com.tent.cloud.sp;

import com.tent.common.jpa.Ajax;
import com.tent.common.jpa.PageUtils;
import com.tent.common.jpa.Result;
import com.tent.common.jpa.Servlets;
import com.tent.common.utils.B;
import com.tent.common.utils.S;
import com.tent.po.entity.sp.Category;
import com.tent.service.inte.sp.ICategoryService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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

            Map<String,Object> searchParams = Servlets.getParametersStartingWith(request,model);

            Pageable pageable = PageUtils.pageable(request);

            Page<Category> list = this.categoryService.findPageList(pageable);

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
    public String add(@RequestParam(value = "id",defaultValue = "") String id,
            Model model,HttpServletRequest request,HttpSession session){
        if (B.Y(id))
            model.addAttribute("data",new Category());
        else
            model.addAttribute("data",this.categoryService.findById(id));
        return S.toPage("category/add");
    }

    @RequestMapping(value = "add.json",method = RequestMethod.POST)
    @ResponseBody
    public Ajax add(Category category, Model model, HttpServletRequest request, HttpSession session){
        try {
            System.out.println(request.getParameter("sname"));
            this.categoryService.save(category);
            if (B.Y(category.getId()))
                return Ajax.success("品种添加成功");
            else
                return Ajax.success("品种修改成功");
        }catch (ServiceException ex){
            ex.printStackTrace();
            return Ajax.failure(ex.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return Ajax.failure(e.getMessage());
        }
    }

}
