package com.kirito.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kirito.test.domain.YUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author kirito
 * @since 2023-08-15 17:42:20
 */
public interface IYUserService extends IService<YUser> {

    YUser findOneByUserName(String userName);

}
