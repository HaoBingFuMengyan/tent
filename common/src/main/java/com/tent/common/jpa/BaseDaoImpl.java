package com.tent.common.jpa;

import com.google.common.collect.Maps;
import com.tent.common.persistence.DynamicSpecifications;
import com.tent.common.persistence.SearchFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
public class BaseDaoImpl<T,ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseDao<T,ID> {

    private EntityManager em;

    public BaseDaoImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
    }

    @Override
    public Page<T> findPage(Pageable var1, Specification<T> var2) {
        return this.findAll((Specification)var2, (Pageable)var1);
    }

    @Override
    public Page<T> findPage(Pageable var1, Map<String, Object> var2, SearchFilter... var3) {
        Object ss;
        if(var2 != null) {
            ss = SearchFilter.parse(var2);
        } else {
            ss = Maps.newHashMap();
        }

        SearchFilter[] var6 = var3;
        int var7 = var3.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            SearchFilter sf = var6[var8];
            ((Map)ss).put(sf.fieldName, sf);
        }

        Specification<T> spec = DynamicSpecifications.bySearchFilter(((Map)ss).values(), this.getDomainClass(), new String[0]);
        return this.findAll((Specification)spec, (Pageable)var1);
    }

    @Override
    public Page<T> findPage(Pageable var1, Map<String, Object> var2, Specification<T> var3) {
        Object ss;
        if(var2 != null) {
            ss = SearchFilter.parse(var2);
        } else {
            ss = Maps.newHashMap();
        }

        final Specification<T> spec = DynamicSpecifications.bySearchFilter(((Map)ss).values(), this.getDomainClass(), new String[0]);
        Specification<T> last = new Specification<T>() {
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return var3 == null?spec.toPredicate(root, query, cb):cb.and(spec.toPredicate(root, query, cb), var3.toPredicate(root, query, cb));
            }
        };
        return this.findAll((Specification)last, (Pageable)var1);
    }

    @Override
    public List<T> findAll(Map<String, Object> var1, SearchFilter... var2) {
        Object ss;
        if(var1 != null) {
            ss = SearchFilter.parse(var1);
        } else {
            ss = Maps.newHashMap();
        }

        SearchFilter[] var5 = var2;
        int var6 = var2.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            SearchFilter sf = var5[var7];
            if(sf.value != null) {
                ((Map)ss).put(sf.fieldName, sf);
            }
        }

        Specification<T> spec = DynamicSpecifications.bySearchFilter(((Map)ss).values(), this.getDomainClass(), new String[0]);
        return this.findAll(spec);
    }
}
