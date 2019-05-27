package com.tent.common.jpa;

import com.google.common.collect.Maps;
import com.tent.common.persistence.Filter;
import com.tent.common.persistence.QueryParams;
import com.tent.common.utils.AnnotationUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
public class BaseDaoImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseDao<T, ID> {

    private EntityManager em;

    public BaseDaoImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
    }

    @Override
    public T fetchOne(ID var1) {
        T obj = this.findOne(var1);
        if (obj != null) {
            AnnotationUtils.fetchAll(obj, false);
        }
        return obj;
    }

    @Override
    public List<?> findBySql(String var1, Object... var2) {
        Query query = this.em.createNativeQuery(var1);
        if (var2 != null && var2.length > 0) {
            for (int i = 0; i < var2.length; ++i) {
                if (var2[i] instanceof Date) {
                    query.setParameter(i + 1, (Date) var2[i], TemporalType.DATE);
                } else {
                    query.setParameter(i + 1, var2[i]);
                }
            }
        }

        return query.getResultList();
    }

    @Override
    public List<?> findByHql(String var1, Object... var2) {
        Query query = this.em.createQuery(var1);
        if (var2 != null) {
            for (int i = 0; i < var2.length; ++i) {
                query.setParameter(i + 1, var2[i]);
            }
        }

        return query.getResultList();
    }

    @Override
    public List<T> findByPropertyName(String var1, Object var2) {
        String sql = "FROM " + this.getDomainClass().getSimpleName() + " t WHERE t." + var1 + "= :" + var1;
        Query query = this.em.createQuery(sql);
        query.setParameter(var1, var2);
        return query.getResultList();
    }

    @Override
    public T findOneByPropertyName(String var1, Object var2) {
        return this.findOne(new Specification<T>() {
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get(var1), var2);
            }
        });
    }

    @Override
    public Page<T> findPage(Pageable var1, Specification<T> var2) {
        return this.findAll((Specification) var2, (Pageable) var1);
    }

    @Override
    public Page<T> findPage(Pageable var1, Map<String, Object> var2, Filter... var3) {
        Object ss;
        if (var2 != null) {
            ss = Filter.parse(var2);
        } else {
            ss = Maps.newHashMap();
        }

        Filter[] var6 = var3;
        int var7 = var3.length;

        for (int var8 = 0; var8 < var7; ++var8) {
            Filter sf = var6[var8];
            ((Map) ss).put(sf.getProperty(), sf);
        }

        Specification<T> spec = QueryParams.byFilter(((Map) ss).values(), this.getDomainClass(), new String[0]);
        return this.findAll((Specification) spec, (Pageable) var1);

    }

    @Override
    public Page<T> findPage(Pageable var1, Map<String, Object> var2, Specification<T> var3) {
        Object ss;
        if (var2 != null) {
            ss = Filter.parse(var2);
        } else {
            ss = Maps.newHashMap();
        }

        final Specification<T> spec = QueryParams.byFilter(((Map) ss).values(), this.getDomainClass(), new String[0]);
        Specification<T> last = new Specification<T>() {
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return var3 == null ? spec.toPredicate(root, query, cb) : cb.and(spec.toPredicate(root, query, cb), var3.toPredicate(root, query, cb));
            }
        };
        return this.findAll((Specification) last, (Pageable) var1);
    }

    @Override
    public List<T> findAll(Map<String, Object> var1, Filter... var2) {
        Object ss;
        if (var1 != null) {
            ss = Filter.parse(var1);
        } else {
            ss = Maps.newHashMap();
        }

        Filter[] var5 = var2;
        int var6 = var2.length;

        for (int var7 = 0; var7 < var6; ++var7) {
            Filter sf = var5[var7];
            if (sf.getValue() != null) {
                ((Map) ss).put(sf.getProperty(), sf);
            }
        }

        Specification<T> spec = QueryParams.byFilter(((Map) ss).values(), this.getDomainClass(), new String[0]);
        return this.findAll(spec);
    }

    @Override
    public List<T> findByQueryParam(QueryParams queryParams, Pageable pageable) {
        StringBuilder sql = new StringBuilder("select * from " + this.getDomainClass().getSimpleName() + " where 1=1 ");
        List values = QueryParams.analysisQueryParams(sql, queryParams);
        Query query = this.em.createQuery(sql.toString());
        for (int i = 0; i < values.size(); i++) {
            query.setParameter(i + 1, values.get(i));
        }
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        return query.getResultList();
    }

    @Override
    public Object getFieldValue(String var1, Object... var2) {
        Query query = this.em.createNativeQuery(var1);
        if(var2 != null && var2.length > 0) {
            for(int i = 0; i < var2.length; ++i) {
                if(var2[i] instanceof Date) {
                    query.setParameter(i + 1, (Date)var2[i], TemporalType.DATE);
                } else {
                    query.setParameter(i + 1, var2[i]);
                }
            }
        }

        return query.getSingleResult();
    }


}
