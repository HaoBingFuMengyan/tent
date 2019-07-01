package com.tent.service.impl.sys;

import com.tent.common.jpa.BaseDao;
import com.tent.common.jpa.BaseService;
import com.tent.dao.sys.SequenceDao;
import com.tent.po.entity.sys.Sequence;
import com.tent.service.inte.sys.ISequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component
@Transactional
public class SequenceService extends BaseService<Sequence> implements ISequenceService {

    @Autowired
    private SequenceDao sequenceDao;

    @Override
    protected BaseDao<Sequence, String> getBaseDao() {
        return this.sequenceDao;
    }

    @Override
    protected void BaseSaveCheck(Sequence obj) {

    }


    @Override
    public Page<Sequence> pageList(Map<String, Object> searchParams, Pageable pageable) {
        return this.sequenceDao.findPage(pageable,searchParams);
    }
}
