package com.tent.common.jpa;

import com.google.common.collect.Lists;
import com.tent.common.utils.B;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.servlet.ServletRequest;
import java.util.List;

public class PageUtils {

    static public final int MaxLimit=100;
    static public final int DefaultLimit=20;
    static public final String Limit="20";

    public PageUtils() {
    }

    /**
     * @param sorts 例子: desc_time
     * @return
     */
    static public Sort toSort(String... sorts){
        Sort ss=null;
        if(sorts != null && sorts.length>0)
        {
            List<Sort.Order> orders= Lists.newArrayList();
            for(String sort:sorts){
                if(B.Y(sort))
                    continue;
                String [] keys=sort.split("_");
                Sort.Direction direct = Sort.Direction.DESC;
                if("asc".equalsIgnoreCase(keys[0]))
                    direct=Sort.Direction.ASC;
                orders.add(new Sort.Order(direct, keys[1]));
            }
            if(orders.size() != 0)
                ss= new Sort(orders);
        }
        return ss;

    }

    static public PageRequest page(int page, int size){

        PageRequest p= new PageRequest(page,size);

        return p;

    }
    static public PageRequest page(int page, int size, String... sort){
        PageRequest p= new PageRequest(page,size,toSort(sort));
        return p;
    }
    static public PageRequest page(int page, int size,Sort sort){

        PageRequest p= new PageRequest(page,size,sort);
        return p;

    }

    static public PageRequest sumPage(int page, int size,String[] sumcols, String... sort){

        PageSumRequest p= new PageSumRequest(page,size,toSort(sort),sumcols);
        return p;
    }
    static public PageRequest sumPage(int page, int size,Sort sort,String...sumcols){

        PageSumRequest p= new PageSumRequest(page,size,sort,sumcols);
        return p;

    }

    static public PageRequest pageable(ServletRequest request){
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String[] sort = request.getParameterValues("sort");
        //jpa页码从0开始
        PageRequest p = new PageRequest(B.Y(page)?0:Integer.parseInt(page)-1,B.Y(limit)?PageUtils.DefaultLimit:Integer.parseInt(limit), toSort(sort));

        return p;
    }

}
