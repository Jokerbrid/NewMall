package com.mall.auth.service.impl;

import com.alibaba.nacos.shaded.com.google.gson.Gson;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mall.auth.model.dto.AuthUserDto;
import com.mall.auth.model.po.MallUser;
import com.mall.auth.mapper.MallUserMapper;
import com.mall.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    MallUserMapper mallUserMapper;
    @Autowired
    ApplicationContext applicationContext;
    //重写Security的认证方法：
    @Override
    public UserDetails loadUserByUsername(String jsonUser) throws UsernameNotFoundException {
        Gson gson=new Gson();
        AuthUserDto user=gson.fromJson(jsonUser,AuthUserDto.class);
        AuthService authService = applicationContext.getBean(user.getAuthType()+"_authService", AuthService.class);

        MallUser mallUser = authService.authenticate(user);
        String password=mallUser.getPassword();

        mallUser.setPassword(null);
        String userJson=gson.toJson(mallUser);

        UserDetails userDetails = User.withUsername(userJson).authorities("default").password(password).build();
        return userDetails;
    }
}
