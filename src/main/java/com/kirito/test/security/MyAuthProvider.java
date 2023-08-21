//package com.kirito.test.security;
//
//import jakarta.annotation.Resource;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.AuthenticationServiceException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class MyAuthProvider extends AbstractUserDetailsAuthenticationProvider {
//
//    @Resource
//    private UserService userService;
//    @Resource
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Override
//    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//        User user = (User) userDetails;
//        String loginPassword = authentication.getCredentials().toString();
//        log.info("user:{},loginPassword:{}", user.getPassword(), loginPassword);
//        if (!passwordEncoder.matches(loginPassword, user.getPassword())) {
//            throw new AuthenticationServiceException("账号或密码错误");
//        }
//        authentication.setDetails(user);
//    }
//
//    @Override
//    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//        log.info("username:{}", username);
//        return userService.loadUserByUsername(username);
//    }
//
//}