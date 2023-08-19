package com.kirito.test.service.impl;

import com.kirito.test.domain.YUser;
import com.kirito.test.mapper.YUserMapper;
import com.kirito.test.service.IYUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author kirito
 * @since 2023-08-15 17:42:20
 */
@Service
public class YUserServiceImpl extends ServiceImpl<YUserMapper, YUser> implements IYUserService {

}
