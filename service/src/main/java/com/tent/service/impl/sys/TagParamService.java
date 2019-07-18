package com.tent.service.impl.sys;

import com.tent.common.service.IParameterService;
import com.tent.dao.sys.SequenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
public class TagParamService implements IParameterService{


    @Autowired
    private SequenceDao sequenceDao;

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public String genarateSeqNo(String name) {
        return sequenceDao.getSeqNo(name);
    }
}
