package com.tent.common.jpa;

import com.tent.common.exception.E;
import com.tent.common.utils.StringUtils;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

public abstract class BaseService<T> {

    protected abstract BaseDao<T, String> getBaseDao();

    protected abstract void BaseSaveCheck(T obj);

    @Transactional(readOnly = true)
    public Page<T> listPage(Pageable page, Specification<T> spec) {
        return getBaseDao().findAll(spec, page);
    }

    @Transactional(readOnly = true)
    public Page<T> listpage(Map<String, Object> searchParams, Pageable pageable) {
        return getBaseDao().findPage(pageable,searchParams);
    }

    @Transactional(readOnly = true)
    public Page<T> listpage(Pageable page, Map<String, Object> searchParams, Specification<T> spec){
        return getBaseDao().findPage(page,searchParams,spec);
    }

    /**
     * 保存或修改单据编号 void
     */
    @Transactional
    public T BaseSave(T obj, String id) throws ServiceException {
        BaseSaveCheck(obj);
        obj = getBaseDao().save(obj);
        return obj;
    }

    /**
     * 根据id数组删除单据编号
     *
     * @param inds 单据编号数组
     */
    @Transactional
    public void BaseDelete(String[] inds) throws ServiceException {
        try {
            for (String id : inds) {
                if (StringUtils.isNotBlank(id)) {
                    T obj = getBaseDao().findOne(id);
                    if (obj != null) {
                        BaseDeleteBefore(id, obj);
                        getBaseDao().delete(obj);
                    }
                }
            }
        } catch (ServiceException ex) {
            E.S(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServiceException("根据id数组删除单据编号失败");
        }
    }

    @Transactional
    protected void BaseDeleteBefore(String id, T obj) {

    }

    /**
     * 根据id获取单据编号对象 Product
     */
    @Transactional(readOnly = true)
    public T findOne(String id) {
        return getBaseDao().findOne(id);
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return getBaseDao().findAll();
    }

    @Transactional(readOnly = true)
    public List<T> findByColumn(String colName, Object colValue) {
        return getBaseDao().findByPropertyName(colName, colValue);
    }

    @Transactional(readOnly = true)
    public T findByColname(String colName, Object colValue) {
        return getBaseDao().findOneByPropertyName(colName,colValue);
    }
    /**
     * 根据列查找唯一对象
     *
     * @param colName
     * @param colValue
     * @return
     */
    @Transactional(readOnly = true)
    public T findOneByProperty(final String colName, final Object colValue) {
        return getBaseDao().findOne(new Specification<T>() {

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.equal(root.get(colName), colValue);
            }
        });
    }

}
