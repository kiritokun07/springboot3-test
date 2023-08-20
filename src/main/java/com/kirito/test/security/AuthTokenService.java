package com.kirito.test.security;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AuthTokenService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public String createToken(User user) {
        String userName = user.getUsername();
        String token = DigestUtils.md5DigestAsHex(userName.getBytes());
        log.info("user-name:{},create-token:{}", userName, token);
        redisTemplate.opsForValue().set(token, user, 10, TimeUnit.MINUTES);
        return token;
    }

    public Object getToken(String token) {
        return redisTemplate.opsForValue().get(token);
    }

    public Boolean deleteToken(String token) {
        return redisTemplate.delete(token);
    }
}