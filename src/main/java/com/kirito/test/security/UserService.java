package com.kirito.test.security;

import com.kirito.test.domain.YUser;
import com.kirito.test.service.IYUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author kirito
 * @date 2023-08-20 16:38:35
 * @desc ...
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final IYUserService iyUserService;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        YUser queryUser = iyUserService.findOneByUserName(userName);
        if (Objects.isNull(queryUser)) {
            throw new AuthException("该用户不存在");
        }
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_Admin")); //for循环添加userRole
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_User")); //for循环添加userRole
        return new User(queryUser.getName(), queryUser.getPass(), grantedAuthorityList);
    }

    public Boolean register(YUser userBase) {
        if (Objects.isNull(userBase)) {
            return false;
        }
        userBase.setPass(passwordEncoder.encode(userBase.getPass()));
        userBase.setCreateTime(LocalDateTime.now());
        return iyUserService.save(userBase);
    }

    public YUser getById(Integer id) {
        return iyUserService.getById(id);
    }

}
