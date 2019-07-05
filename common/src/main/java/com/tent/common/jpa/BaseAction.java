package com.tent.common.jpa;

import com.tent.common.utils.B;
import com.tent.common.utils.S;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.service.spi.ServiceException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

public abstract class BaseAction<T,V> {
    public BaseAction(){

    }

    public abstract BaseService<T> getBaseService();

    public abstract String positionJsp();

    public abstract String prefixJsp();


    @ModelAttribute
    public void prepareData(@RequestParam(value = "id",defaultValue = "") String id,Model model,HttpServletRequest request){
        if (B.N(id)){
            T product = this.getBaseService().findOne(id);
            if (product != null) {
                try {
                    model.addAttribute("oriObj", BeanUtils.cloneBean(product));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                model.addAttribute("data", poToVo(product));
            }
        }
    }

    @RequestMapping(value = "add.shtml")
    public String add(Model model, HttpServletRequest request, HttpSession session){
        System.out.println("页面路径为：" + this.positionJsp() + "/" + this.prefixJsp() + "-add");
        return S.toPage(this.positionJsp() + "/" + this.prefixJsp() + "-add");
    }

    @RequestMapping(value = "add.json",method = RequestMethod.POST)
    @ResponseBody
    public Ajax add(@Valid @ModelAttribute("data") V obj, Model model, HttpServletRequest request, HttpSession session){
        try {
            save(obj,model,request);
            return Ajax.success("操作成功");
        }catch (ServiceException ex){
            ex.printStackTrace();
            return Ajax.failure(ex.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return Ajax.failure(e.getMessage());
        }
    }

    public void save(V obj,Model model,HttpServletRequest request){
        getBaseService().BaseSave(voToPo(obj),"");
    }

    @SuppressWarnings("unchecked")
    private V poToVo(T obj) {
        // if(tCls.equals(vCls))
        return (V) obj;
        // else
        // return BeanMapper.map(obj, vCls);
    }

    @SuppressWarnings("unchecked")
    protected T voToPo(V obj) {
        // if(tCls.equals(vCls))
        return (T) obj;
        // else
        // return BeanMapper.map(obj, tCls);

    }
}
