package com.kirito.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kirito.test.domain.YUser;
import com.kirito.test.mapper.YUserMapper;
import com.kirito.test.service.IYUserService;
import com.kirito.test.consts.Const;
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

    @Override
    public YUser findOneByUserName(String userName) {
        return this.lambdaQuery()
                .eq(YUser::getName, userName)
                .last(Const.LIMIT_1)
                .one();
    }

}
