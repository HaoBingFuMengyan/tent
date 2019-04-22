package com.tent.service.impl.sp;

import com.tent.dao.sp.CategoryDao;
import com.tent.po.entity.sp.Category;
import com.tent.service.inte.sp.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Page<Category> findPageList(Pageable pageable) {
        return this.categoryDao.findAll(pageable);
    }
}
