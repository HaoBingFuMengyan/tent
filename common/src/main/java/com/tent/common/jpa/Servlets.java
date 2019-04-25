package com.tent.common.jpa;

import org.apache.commons.lang3.Validate;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Servlets {

    public Servlets() {
    }

    public static Map<String, Object> getParametersStartingWith(ServletRequest request) {
        return getParametersStartingWith(request, "search_");
    }

    public static Map<String, Object> getParametersStartingWith(ServletRequest request, Model model) {
        Map<String, Object> map = getParametersStartingWith(request, "search_");
        if(model instanceof RedirectAttributes) {
            RedirectAttributes r = (RedirectAttributes)model;
            Iterator var4 = map.entrySet().iterator();

            while(var4.hasNext()) {
                Map.Entry<String, Object> en = (Map.Entry)var4.next();
                r.addFlashAttribute((String)en.getKey(), en.getValue());
            }
        } else {
            model.addAllAttributes(map);
        }

        return map;
    }

    public static Map<String, Object> getParametersStartingWith(ServletRequest request, String prefix) {
        Validate.notNull(request, "Request must not be null", new Object[0]);
        Enumeration paramNames = request.getParameterNames();
        Map<String, Object> params = new HashMap();
        if(prefix == null) {
            prefix = "";
        }

        while(paramNames != null && paramNames.hasMoreElements()) {
            String paramName = (String)paramNames.nextElement();
            if("".equals(prefix) || paramName.startsWith(prefix)) {
                String[] values = request.getParameterValues(paramName);
                if(values != null && values.length != 0) {
                    if(values.length > 1) {
                        params.put(paramName, values);
                    } else {
                        params.put(paramName, values[0]);
                    }
                }
            }
        }

        return params;
    }
}
