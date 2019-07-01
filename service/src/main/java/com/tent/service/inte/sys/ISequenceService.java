package com.tent.service.inte.sys;

import com.tent.po.entity.sys.Sequence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by haobingfu on 2019/6/29.
 */
public interface ISequenceService {

    Page<Sequence> pageList(Map<String,Object> searchParams, Pageable pageable);
}
