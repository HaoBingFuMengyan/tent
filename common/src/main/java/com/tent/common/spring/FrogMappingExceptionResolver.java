package com.tent.common.spring;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrogMappingExceptionResolver extends SimpleMappingExceptionResolver {
    public FrogMappingExceptionResolver() {
    }

    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String viewName = this.determineViewName(ex, request);
        if(viewName != null) {
            Integer statusCode = this.determineStatusCode(request, viewName);
            if(statusCode != null) {
                this.applyStatusCodeIfPossible(request, response, statusCode.intValue());
            }

            if(request.getRequestURI().endsWith(".json") || request.getRequestURI().endsWith(".jhtml")) {
                viewName = viewName.replace("error", "mobile-error");
            }

            return this.getModelAndView(viewName, ex, request);
        } else {
            return null;
        }
    }
}
