package com.tent.cloud.sys;

import com.tent.common.jpa.*;
import com.tent.common.utils.S;
import com.tent.po.entity.sys.Sequence;
import com.tent.service.impl.sys.SequenceService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "sys/sequence")
public class SequenceAction extends BaseAction<Sequence,Sequence>{

    @Autowired
    private SequenceService sequenceService;

    @RequestMapping(value = "list.shtml")
    public String list(Model model, HttpServletRequest request, HttpSession session){
        return S.toPage("sys/sequence-list");
    }

    @RequestMapping(value = "list.json")
    @ResponseBody
    public Result data(Model model, HttpServletRequest request, HttpSession session){
        try {

            Map<String,Object> searchParams = Servlets.getParametersStartingWith(request,model);

            Pageable pageable = PageUtils.pageable(request);

            Page<Sequence> list = this.sequenceService.pageList(searchParams,pageable);

            return  Result.success(list,"");
        }catch (ServiceException ex){
            ex.printStackTrace();
            return Result.failure(ex.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return Result.failure(e.getMessage());
        }
    }

    @Override
    public BaseService<Sequence> getBaseService() {
        return this.sequenceService;
    }

    @Override
    public String positionJsp() {
        return "sys";
    }

    @Override
    public String prefixJsp() {
        return "sequence";
    }

}
