package com.kirito.test.security;

import com.kirito.test.domain.YUser;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {

    @Resource
    private AuthTokenService authTokenService;
    @Resource
    private AuthenticationManager authenticationManager;

    public String doLogin(YUser userBase) {
        AbstractAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userBase.getName().trim(), userBase.getPass().trim());
        Authentication authentication = authenticationManager.authenticate(authToken);
        User user = (User) authentication.getDetails();
        return authTokenService.createToken(user);
    }

    public Boolean doLogout(String authToken) {
        SecurityContextHolder.clearContext();
        return authTokenService.deleteToken(authToken);
    }
}