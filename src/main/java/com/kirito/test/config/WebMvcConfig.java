//package com.kirito.test.config;
//
//import com.kirito.test.interceptor.BodyInterceptor;
//import com.kirito.test.interceptor.HeadInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//
//    /**
//     * 添加自定义拦截器
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new HeadInterceptor()).addPathPatterns("/**").excludePathPatterns();
//        registry.addInterceptor(new BodyInterceptor()).addPathPatterns("/**");
//    }
//}