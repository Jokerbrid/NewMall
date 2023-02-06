package com.mall.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mall.auth.mapper.MallUserMapper;
import com.mall.auth.model.dto.AuthUserDto;
import com.mall.auth.model.po.MallUser;
import com.mall.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("dir_authService")
public class PasswordAuthServiceImpl implements AuthService {
    @Autowired
    MallUserMapper mallUserMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public MallUser authenticate(AuthUserDto authUserDto) {
        String passwordForm=authUserDto.getPassword();
        //查询数据库：
        LambdaQueryWrapper<MallUser> wrapper=new LambdaQueryWrapper<MallUser>()
                .eq(MallUser::getUsername,authUserDto.getUsername());
        MallUser user = mallUserMapper.selectOne(wrapper);
        //由于数据库存放的是密文：
        String passwordDb= user.getPassword();
        //比对密文：
        boolean matches = passwordEncoder.matches(passwordForm, passwordDb);
        if(!matches){
            throw new RuntimeException("账户或者密码错误!");
        }
        return user;
    }
}
