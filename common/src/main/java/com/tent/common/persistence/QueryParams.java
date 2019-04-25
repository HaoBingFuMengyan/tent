package com.tent.common.persistence;

import com.google.common.collect.Lists;
import com.tent.common.utils.Collections3;
import com.tent.common.utils.DateUtils;
import com.tent.common.utils.StringUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.*;

/**
 * 封装查询实体
 */
public class QueryParams<T> implements Specification<T> {
    /**
     * 属性分隔符
     */
    private static final String PROPERTY_SEPARATOR = ".";
    /**
     * and条件
     */
    private List<Filter> andFilters = new ArrayList<>();
    /**
     * or条件
     */
    private List<Filter> orFilters = new ArrayList<>();
    /**
     * 排序属性
     */
    private List<Order> orders = new ArrayList<>();

    /**
     * 获取Path
     *
     * @param path         Path
     * @param propertyPath 属性路径
     * @return Path
     */
    @SuppressWarnings("unchecked")
    private <X> Path<X> getPath(Path<?> path, String propertyPath) {
        if (path == null || StringUtils.isEmpty(propertyPath)) {
            return (Path<X>) path;
        }
        String property = StringUtils.substringBefore(propertyPath, PROPERTY_SEPARATOR);
        return getPath(path.get(property), StringUtils.substringAfter(propertyPath, PROPERTY_SEPARATOR));
    }

    /**
     * 转换为Predicate
     *
     * @param root Root
     * @return Predicate
     */
    @SuppressWarnings("unchecked")
    private Predicate toAndPredicate(Root<T> root, CriteriaBuilder criteriaBuilder) {
        Predicate restrictions = criteriaBuilder.conjunction();
        if (root == null || Collections3.isEmpty(andFilters)) {
            return restrictions;
        }
        for (Filter filter : andFilters) {
            if (filter == null) {
                continue;
            }
            String property = filter.getProperty();
            Filter.Operator operator = filter.getOperator();
            Object value = filter.getValue();
            Boolean ignoreCase = filter.getIgnoreCase();
            Path<?> path = getPath(root, property);
            if (path == null) {
                continue;
            }
            //根据运算符生成相应条件
            switch (operator) {
                case eq:
                    if (value != null) {
                        if (BooleanUtils.isTrue(ignoreCase) && String.class.isAssignableFrom(path.getJavaType()) && value instanceof String) {
                            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(criteriaBuilder.lower((Path<String>) path), ((String) value).toLowerCase()));
                        } else {
                            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(path, value));
                        }
                    } else {
                        restrictions = criteriaBuilder.and(restrictions, path.isNull());
                    }
                    break;
                case ne:
                    if (value != null) {
                        if (BooleanUtils.isTrue(ignoreCase) && String.class.isAssignableFrom(path.getJavaType()) && value instanceof String) {
                            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.notEqual(criteriaBuilder.lower((Path<String>) path), ((String) value).toLowerCase()));
                        } else {
                            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.notEqual(path, value));
                        }
                    } else {
                        restrictions = criteriaBuilder.and(restrictions, path.isNotNull());
                    }
                    break;
                case gt:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.gt((Path<Number>) path, (Number) value));
                    }
                    break;
                case lt:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.lt((Path<Number>) path, (Number) value));
                    }
                    break;
                case ge:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.ge((Path<Number>) path, (Number) value));
                    }
                    break;
                case le:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.le((Path<Number>) path, (Number) value));
                    }
                    break;
                case like:
                    if (String.class.isAssignableFrom(path.getJavaType()) && value instanceof String) {
                        if (BooleanUtils.isTrue(ignoreCase)) {
                            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.like(criteriaBuilder.lower((Path<String>) path), ((String) value).toLowerCase()));
                        } else {
                            restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.like((Path<String>) path, (String) value));
                        }
                    }
                    break;
                case in:
                    restrictions = criteriaBuilder.and(restrictions, path.in(value));
                    break;
                case isNull:
                    restrictions = criteriaBuilder.and(restrictions, path.isNull());
                    break;
                case isNotNull:
                    restrictions = criteriaBuilder.and(restrictions, path.isNotNull());
                    break;
            }
        }
        return restrictions;
    }

    /**
     * 转换为Predicate
     *
     * @param root Root
     * @return Predicate
     */
    @SuppressWarnings("unchecked")
    private Predicate toOrPredicate(Root<T> root, CriteriaBuilder criteriaBuilder) {
        Predicate restrictions = criteriaBuilder.disjunction();
        if (root == null || Collections3.isEmpty(andFilters)) {
            return restrictions;
        }
        for (Filter filter : orFilters) {
            if (filter == null) {
                continue;
            }
            String property = filter.getProperty();
            Filter.Operator operator = filter.getOperator();
            Object value = filter.getValue();
            Boolean ignoreCase = filter.getIgnoreCase();
            Path<?> path = getPath(root, property);
            if (path == null) {
                continue;
            }
            switch (operator) {
                case eq:
                    if (value != null) {
                        if (BooleanUtils.isTrue(ignoreCase) && String.class.isAssignableFrom(path.getJavaType()) && value instanceof String) {
                            restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.equal(criteriaBuilder.lower((Path<String>) path), ((String) value).toLowerCase()));
                        } else {
                            restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.equal(path, value));
                        }
                    } else {
                        restrictions = criteriaBuilder.or(restrictions, path.isNull());
                    }
                    break;
                case ne:
                    if (value != null) {
                        if (BooleanUtils.isTrue(ignoreCase) && String.class.isAssignableFrom(path.getJavaType()) && value instanceof String) {
                            restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.notEqual(criteriaBuilder.lower((Path<String>) path), ((String) value).toLowerCase()));
                        } else {
                            restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.notEqual(path, value));
                        }
                    } else {
                        restrictions = criteriaBuilder.or(restrictions, path.isNotNull());
                    }
                    break;
                case gt:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.gt((Path<Number>) path, (Number) value));
                    }
                    break;
                case lt:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.lt((Path<Number>) path, (Number) value));
                    }
                    break;
                case ge:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.ge((Path<Number>) path, (Number) value));
                    }
                    break;
                case le:
                    if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
                        restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.le((Path<Number>) path, (Number) value));
                    }
                    break;
                case like:
                    if (String.class.isAssignableFrom(path.getJavaType()) && value instanceof String) {
                        if (BooleanUtils.isTrue(ignoreCase)) {
                            restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.like(criteriaBuilder.lower((Path<String>) path), ((String) value).toLowerCase()));
                        } else {
                            restrictions = criteriaBuilder.or(restrictions, criteriaBuilder.like((Path<String>) path, (String) value));
                        }
                    }
                    break;
                case in:
                    restrictions = criteriaBuilder.or(restrictions, path.in(value));
                    break;
                case isNull:
                    restrictions = criteriaBuilder.or(restrictions, path.isNull());
                    break;
                case isNotNull:
                    restrictions = criteriaBuilder.or(restrictions, path.isNotNull());
                    break;
            }
        }
        return restrictions;
    }

    public static <T> Specification<T> byFilter(final Collection<Filter> filters, final Class<T> clazz , final String ...fetch) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

                if (Collections3.isNotEmpty(filters)) {

                    List<Predicate> predicates = Lists.newArrayList();
                    for (Filter filter : filters) {
                        // nested path translate, 如Task的名为"user.name"的filedName,
                        // 转换为Task.user.name属性
                        String[] names = org.apache.commons.lang3.StringUtils.split(filter.getProperty(), ".");
                        Path expression = root.get(names[0]);
                        for (int i = 1; i < names.length; i++) {

                            if (Collection.class.isAssignableFrom(expression.getJavaType())) {
                                expression = root.join(names[0]).get(names[i]);
                            } else
                                expression = expression.get(names[i]);
                        }

                        for(int i=0;i<fetch.length;i++){
                            String s=fetch[i];
                            root.fetch(s);
                        }
                        Object val = filter.getValue();
                        if (expression.getJavaType().equals(Date.class)) {
                            if (val instanceof String)
                                if(((String) val).length() > 10)
                                    val = DateUtils.parseDateByFormat(val.toString().replace("T", " "),"yyyy-MM-dd HH:mm:ss");
                                else
                                    val = DateUtils.parseDate(val.toString());
                        }

                        switch (filter.getOperator()) {
                            case eq:
                                if (val == null)
                                    predicates.add(expression.isNull());
                                else
                                    predicates.add(builder.equal(expression, val));
                                break;
                            case ne:
                                predicates.add(builder.notEqual(expression, (Comparable) val));
                                break;
                            case gt:
                                predicates.add(builder.greaterThan(expression, (Comparable) val));
                                break;
                            case lt:
                                predicates.add(builder.lessThan(expression, (Comparable) val));
                                break;
                            case ge:
                                predicates.add(builder.ge(expression,(Number) val));
                                break;
                            case le:
                                predicates.add(builder.le(expression,(Number) val));
                                break;
                            case like:
                                predicates.add(builder.like(expression, "%" + val + "%"));
                                break;
                            case in:
                                CriteriaBuilder.In in = builder.in(expression);
                                if (val != null) {
                                    if (val.getClass().isArray()) {
                                        Object[] itemsArray = (Object[]) val;
                                        for (int i = 0; i < itemsArray.length; i++) {
                                            String v = itemsArray[i].toString();
                                            if (expression.getJavaType().equals(Long.class)) {
                                                in.value(Long.valueOf(v));
                                            } else if (expression.getJavaType().equals(Integer.class)) {
                                                in.value(Integer.valueOf(v));
                                            } else {
                                                in.value(v);
                                            }
                                        }
                                    } else {
                                        String[] spl = val.toString().split(",");
                                        if (spl != null && spl.length > 0) {
                                            for (String v : spl) {
                                                if (expression.getJavaType().equals(Long.class)) {
                                                    in.value(Long.valueOf(v));
                                                } else if (expression.getJavaType().equals(Integer.class)) {
                                                    in.value(Integer.valueOf(v));
                                                } else {
                                                    in.value(v);
                                                }
                                            }
                                        }
                                    }
                                }

                                predicates.add(in);
                                break;
                            case isNull:
                                predicates.add(builder.isNull(expression));
                                break;
                            case isNotNull:
                                predicates.add(builder.isNotNull(expression));
                                break;

                        }

                    }
                    // 将所有条件用 and 联合起来
                    if (predicates.size() > 0) {
                        return builder.and(predicates.toArray(new Predicate[predicates.size()]));
                    }
                }

                return builder.conjunction();
            }
        };
    }
    /**
     * 转换为Order
     *
     * @param root Root
     * @return Order
     */
    private List<javax.persistence.criteria.Order> toOrders(Root<T> root, CriteriaBuilder criteriaBuilder) {
        List<javax.persistence.criteria.Order> orderList = new ArrayList<javax.persistence.criteria.Order>();
        if (root == null || Collections3.isEmpty(orders)) {
            return orderList;
        }
        for (Order order : orders) {
            if (order == null) {
                continue;
            }
            String property = order.getProperty();
            Order.Direction direction = order.getDirection();
            Path<?> path = getPath(root, property);
            if (path == null || direction == null) {
                continue;
            }
            switch (direction) {
                case asc:
                    orderList.add(criteriaBuilder.asc(path));
                    break;
                case desc:
                    orderList.add(criteriaBuilder.desc(path));
                    break;
            }
        }
        return orderList;
    }

    /**
     * 生成条件的
     *
     * @param root  该对象的封装
     * @param query 查询构建器
     * @param cb    构建器
     * @return 条件集合
     * 如果无or条件,toOrPredicate会自带一个 or 1=1,前面用and的话则变为and 1=1造成错误,所以这里判断下
     * 这个貌似和版本有关,公司线上版本出现这个问题,本地测试没问题
     */
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        Predicate restrictions = cb.and(toAndPredicate(root, cb));
        if (!orders.isEmpty()) {
            restrictions = cb.and(restrictions, toOrPredicate(root, cb));
        }
        query.orderBy(toOrders(root, cb));
        return restrictions;
    }

    /**
     * 添加一个and条件
     * @param filter 该条件
     * @return 链式调用
     */
    public  QueryParams and(Filter filter){
        this.andFilters.add(filter);
        return this;
    }
    /**
     * 添加多个and条件
     * @param filter 该条件
     * @return 链式调用
     */
    public  QueryParams and(Filter ...filter){
        this.andFilters.addAll(Arrays.asList(filter));
        return this;
    }
    /**
     * 添加一个or条件
     * @param filter 该条件
     * @return 链式调用
     */
    public  QueryParams or(Filter filter){
        this.orFilters.add(filter);
        return this;
    }
    /**
     * 添加多个or条件
     * @param filter 该条件
     * @return 链式调用
     */
    public  QueryParams or(Filter ...filter){
        this.orFilters.addAll(Arrays.asList(filter));
        return this;
    }
    /**
     * 升序字段
     * @param property 该字段对应变量名
     * @return 链式调用
     */
    public  QueryParams orderASC(String property){
        this.orders.add(Order.asc(property));
        return this;
    }
    /**
     * 降序字段
     * @param property 该字段对应变量名
     * @return 链式调用
     */
    public  QueryParams orderDESC(String property){
        this.orders.add(Order.desc(property));
        return this;
    }

    /**
     * 清除所有条件
     * @return 该实例
     */
    public QueryParams clearAll(){
        if (!this.andFilters.isEmpty()) this.andFilters.clear();
        if (!this.orFilters.isEmpty()) this.orFilters.clear();
        if (!this.orders.isEmpty()) this.orders.clear();
        return this;
    }
    /**
     * 清除and条件
     * @return 该实例
     */
    public QueryParams clearAnd(){
        if (!this.andFilters.isEmpty()) this.andFilters.clear();
        return this;
    }
    /**
     * 清除or条件
     * @return 该实例
     */
    public QueryParams clearOr(){
        if (!this.orFilters.isEmpty()) this.andFilters.clear();
        return this;
    }
    /**
     * 清除order条件
     * @return 该实例
     */
    public QueryParams clearOrder(){
        if (!this.orders.isEmpty()) this.orders.clear();
        return this;
    }

    public List<Filter> getAndFilters() {
        return andFilters;
    }

    public void setAndFilters(List<Filter> andFilters) {
        this.andFilters = andFilters;
    }

    public List<Filter> getOrFilters() {
        return orFilters;
    }

    public void setOrFilters(List<Filter> orFilters) {
        this.orFilters = orFilters;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
