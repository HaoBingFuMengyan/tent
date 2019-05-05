package com.tent.common.jpa;

import com.tent.common.persistence.Filter;
import com.tent.common.persistence.QueryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface BaseDao<T, ID extends Serializable>
        extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    T fetchOne(ID var1);

    List<?> findBySql(String var1, Object... var2);

    List<T> findByPropertyName(String var1, Object var2);

    T findOneByPropertyName(String var1, Object var2);

    Page<T> findPage(Pageable var1, Specification<T> var2);

    Page<T> findPage(Pageable var1, Map<String, Object> var2, Filter... var3);

    Page<T> findPage(Pageable var1, Map<String, Object> var2, Specification<T> var3);

    List<T> findAll(Map<String, Object> var1, Filter... var2);

    List<T> findAll(Pageable pageable, QueryParams<?> queryParams);
}
