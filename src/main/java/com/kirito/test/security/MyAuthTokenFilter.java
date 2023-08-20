package com.kirito.test.security;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class MyAuthTokenFilter extends OncePerRequestFilter {

    @Resource
    private AuthTokenService authTokenService;

    @Resource
    private AuthExeHandler authExeHandler;

    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest request,
                                    @Nonnull HttpServletResponse response,
                                    @Nonnull FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (Stream.of(WhiteConfig.whiteList()).anyMatch(uri::startsWith)) {

            //Arrays.asList(WhiteConfig.whiteList()).contains(uri)) {
            // 如果是白名单直接放行
            filterChain.doFilter(request, response);
            return;
        }
        String token = request.getHeader("Auth-Token");
        if (Objects.isNull(token) || token.isEmpty()) {
            // Token不存在，拦截返回
            authExeHandler.commence(request, response, null);
            return;
        }
        Object object = authTokenService.getToken(token);
        if (Objects.isNull(object) || !(object instanceof User user)) {
            // Token验证失败，拦截返回
            authExeHandler.commence(request, response, null);
            return;
        }
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}