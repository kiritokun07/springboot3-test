package com.kirito.test.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 安全配置类
 *
 * @author 公众号:知了一笑
 * @since 2023-07-22 16:47
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    /**
     * 基础配置
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // 配置拦截规则
        httpSecurity.authorizeHttpRequests(authorizeHttpRequests -> {
            authorizeHttpRequests
                    .requestMatchers(WhiteConfig.whiteList())
                    .permitAll()
                    .anyRequest().authenticated();
        });
        // 禁用默认的登录和退出
        httpSecurity.formLogin(AbstractHttpConfigurer::disable);
        httpSecurity.logout(AbstractHttpConfigurer::disable);
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        // 异常时认证处理流程
        httpSecurity.exceptionHandling(exeConfig -> {
            exeConfig.authenticationEntryPoint(authenticationEntryPoint());
        });

        // 添加过滤器
        httpSecurity.addFilterAt(authTokenFilter(), CsrfFilter.class);
        return httpSecurity.build();
    }

    /**
     * 密码加密
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthExeHandler();
    }

    @Bean
    public OncePerRequestFilter authTokenFilter() {
        return new MyAuthTokenFilter();
    }

    /**
     * 认证管理
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(authenticationProvider());
    }

    /**
     * 自定义用户认证
     */
    @Bean
    public AbstractUserDetailsAuthenticationProvider authenticationProvider() {
        return new MyAuthProvider();
    }
}
