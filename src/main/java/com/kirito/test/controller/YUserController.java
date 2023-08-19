package com.kirito.test.controller;

import com.kirito.test.domain.YUser;
import com.kirito.test.service.IYUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author kirito
 * @since 2023-08-15 17:42:20
 */
@RestController
@RequestMapping("/y-user")
@RequiredArgsConstructor
public class YUserController {

    private final IYUserService iyUserService;

    @GetMapping("test1")
    public List<YUser> test1() {
        List<YUser> list = iyUserService.list();
        return list;
    }
}
