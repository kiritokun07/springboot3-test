package com.kirito.test.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final StringRedisTemplate redisTemplate;

    @GetMapping("/test1")
    public String test1() {
        log.info("HELLO");
        return "hello";
    }

    @GetMapping("/test2")
    public String test2() {
        String str = redisTemplate.opsForValue().get("123");
        log.info(str);
        return "result=" + str;
    }

}
