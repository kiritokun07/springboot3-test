package com.kirito.test.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;

/**
 * 拦截器二
 */
public class BodyInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(BodyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        log.info("BodyInterceptor:preHandle");
        Iterator<String> paramNames = request.getParameterNames().asIterator();
        log.info("request-param");
        while (paramNames.hasNext()) {
            String paramName = paramNames.next();
            String paramValue = request.getParameter(paramName);
            System.out.println(paramName + ":" + paramValue);
        }
        // 放开拦截
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        log.info("BodyInterceptor:postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception e) throws Exception {
        log.info("BodyInterceptor:afterCompletion");
    }
}