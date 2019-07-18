package com.tent.common.web;


import com.tent.common.exception.E;
import com.tent.common.service.IParameterService;
import com.tent.common.spring.SpringContextHolder;
import com.tent.common.utils.B;

import java.util.HashMap;
import java.util.Map;

public class ParaUtils {

    private static IParameterService s;
    private static Object o = new Object();
    private static Map<String,Object> sysMap=new HashMap<String, Object>();


    public static String seqno(String sname){
        init();
        String rs = s.genarateSeqNo(sname);
        if(B.Y(rs))
            E.S(String.format("未配置%s的序号生成器",sname));

        return rs;
    }

    private static void init(){
        if(s==null){
            synchronized (o) {
                if(s==null)
                    s= SpringContextHolder.getBean(IParameterService.class);
                if(s==null)
                    E.S("IParameterService的实现类找不到!");
            }

        }
    }
}
