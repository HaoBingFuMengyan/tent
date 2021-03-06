package com.tent.service.inte.sp;

import com.tent.po.entity.sp.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ICategoryService {

    Page<Category> findPageList(Map<String,Object> searchParams, Pageable pageable);

    void save(Category category);

    Category findById(String id);
}
