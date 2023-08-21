//package com.kirito.test.controller;
//
//import com.kirito.test.domain.YUser;
//import com.kirito.test.security.AuthException;
//import com.kirito.test.security.LoginService;
//import jakarta.annotation.Resource;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Objects;
//
///**
// * 登录接口
// *
// * @author 公众号:知了一笑
// * @since 2023-07-22 17:23
// */
//@RestController
//public class LoginWeb {
//
//    @Resource
//    private LoginService loginService;
//
//    @PostMapping(value = "/login")
//    public String doLogin(@RequestBody YUser userBase) {
//        if (Objects.isNull(userBase.getName()) || Objects.isNull(userBase.getPass())) {
//            throw new AuthException("请输入用户名和密码");
//        }
//        return loginService.doLogin(userBase);
//    }
//
//    @PostMapping(value = "/logout")
//    public Boolean doLogout(HttpServletRequest request) {
//        String token = request.getHeader("Auth-Token");
//        if (Objects.isNull(token) || token.isEmpty()) {
//            return Boolean.FALSE;
//        }
//        return loginService.doLogout(token);
//    }
//
//}