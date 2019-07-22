package com.tent.service.impl.sp;

import com.tent.common.jpa.BaseDao;
import com.tent.common.jpa.BaseService;
import com.tent.dao.sp.CommodityDao;
import com.tent.po.entity.sp.Commodity;
import com.tent.service.inte.sp.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CommodityService extends BaseService<Commodity> implements ICommodityService{

    @Autowired
    private CommodityDao commodityDao;


    @Override
    protected BaseDao<Commodity, String> getBaseDao() {
        return this.commodityDao;
    }

    @Override
    protected void BaseSaveCheck(Commodity obj) {

    }

}
