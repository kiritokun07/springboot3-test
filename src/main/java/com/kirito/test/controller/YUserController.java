package com.kirito.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kirito.test.domain.YUser;
import com.kirito.test.service.IYUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("ytest1")
    public IPage<YUser> yTest1() {
        IPage<YUser> page = new Page<>(1, 10);
        LambdaQueryChainWrapper<YUser> queryChainWrapper = iyUserService.lambdaQuery();
        queryChainWrapper.page(page);
        return page;
    }
}
