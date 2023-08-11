package com.kirito.test.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;

/**
 * 拦截器一
 */
public class HeadInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(HeadInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        log.info("HeadInterceptor:preHandle");
        Iterator<String> headNames = request.getHeaderNames().asIterator();
        log.info("request-header");
        while (headNames.hasNext()) {
            String headName = headNames.next();
            String headValue = request.getHeader(headName);
            System.out.println(headName + ":" + headValue);
        }
        // 放开拦截
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        log.info("HeadInterceptor:postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception e) throws Exception {
        log.info("HeadInterceptor:afterCompletion");
    }
}