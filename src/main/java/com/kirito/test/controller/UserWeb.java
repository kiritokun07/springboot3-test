package com.kirito.test.controller;

import com.kirito.test.domain.YUser;
import com.kirito.test.security.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserWeb {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody YUser userBase) {
        return "register-" + userService.register(userBase);
    }

    @GetMapping("/select/{id}")
    public YUser select(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PreAuthorize("hasRole('User')")
    @GetMapping("/user/{id}")
    public YUser getUser(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/admin/{id}")
    public YUser getAdmin(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PreAuthorize("hasAnyRole('User','Admin')")
    @GetMapping("/query/{id}")
    public YUser query(@PathVariable Integer id) {
        return userService.getById(id);
    }
}