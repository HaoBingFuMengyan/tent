package com.tent.service.impl.sp;

import com.tent.common.exception.E;
import com.tent.common.utils.B;
import com.tent.dao.sp.CategoryDao;
import com.tent.po.entity.sp.Category;
import com.tent.service.inte.sp.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component
@Transactional
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Page<Category> findPageList(Map<String,Object> searchParams, Pageable pageable) {
        return this.categoryDao.findPage(pageable,searchParams);
    }

    @Override
    public void save(Category category) {
        if (B.Y(category.getId()))//新增
            newCategory(category);
        else //修改
            modifyCategory(category);
    }

    @Override
    public Category findById(String id) {
        return this.categoryDao.findOne(id);
    }

    private void newCategory(Category category){
        isRequired(category);

        Category data = new Category();

        data.setId(null);
        data.setSname(category.getSname());
        data.setSlocalname(category.getSlocalname());
        data.setSenname(category.getSenname());
        data.setSdescription(category.getSdescription());
        data.setSparentid(category.getSparentid());
        data.setIsort(category.getIsort());
        data.setBiscommon(category.getBiscommon());
        data.setSweightunit(category.getSweightunit());
        data.setSproducer(category.getSproducer());
        data.setShostbrand(category.getShostbrand());
        data.setShostname(category.getShostname());
        data.setShostmodel(category.getShostmodel());

        this.categoryDao.save(data);
    }

    private void modifyCategory(Category category){
        isRequired(category);

        Category data = this.categoryDao.findOne(category.getId());
        if (data == null)
            E.S("正在操作的品种不存在");

        data.setSname(category.getSname());
        data.setSlocalname(category.getSlocalname());
        data.setSenname(category.getSenname());
        data.setSdescription(category.getSdescription());
        data.setSparentid(category.getSparentid());
        data.setIsort(category.getIsort());
        data.setBiscommon(category.getBiscommon());
        data.setSweightunit(category.getSweightunit());
        data.setSproducer(category.getSproducer());
        data.setShostbrand(category.getShostbrand());
        data.setShostname(category.getShostname());
        data.setShostmodel(category.getShostmodel());

        this.categoryDao.save(data);
    }

    /**
     * 验证属性是否必填
     * @param category
     */
    private void isRequired(Category category){
        if (B.Y(category.getSname()))
            E.S("品种名称不能为空！");
        if (B.Y(String.valueOf(category.getBiscommon())))
            E.S("是否常用不能为空！");
        if (B.Y(category.getSweightunit()))
            E.S("单位不能为空！");
        if (B.Y(category.getSproducer()))
            E.S("生产厂家不能为空！");
        if (B.Y(String.valueOf(category.getIsort())))
            E.S("排序号不能为空！");
    }



}
