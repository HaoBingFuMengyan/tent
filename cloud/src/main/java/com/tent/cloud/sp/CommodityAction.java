package com.tent.cloud.sp;

import com.tent.common.jpa.BaseAction;
import com.tent.common.jpa.BaseService;
import com.tent.po.entity.sp.Commodity;
import com.tent.service.impl.sp.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/commodity")
public class CommodityAction extends BaseAction<Commodity,Commodity> {

    @Autowired
    private CommodityService commodityService;

    @Override
    public BaseService<Commodity> getBaseService() {
        return this.commodityService;
    }

    @Override
    public String positionJsp() {
        return "sp";
    }

    @Override
    public String prefixJsp() {
        return "commodity";
    }
}
