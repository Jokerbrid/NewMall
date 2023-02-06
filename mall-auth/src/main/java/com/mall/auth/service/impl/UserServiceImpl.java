package com.mall.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mall.auth.mapper.MallUserMapper;
import com.mall.auth.model.dto.RegisterUserDto;
import com.mall.auth.model.po.MallUser;
import com.mall.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    MallUserMapper mallUserMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public boolean register(RegisterUserDto dto) {
        MallUser same = mallUserMapper.selectOne(new LambdaQueryWrapper<MallUser>()
                .eq(MallUser::getUsername, dto.getUsername()));
        if(same!=null){
            //该用户已存在；
            throw new RuntimeException("该用户已存在");
        }
        MallUser mallUser=new MallUser();
        mallUser.setUsername(dto.getUsername());
        mallUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        mallUser.setCreateDate(new Date());
        mallUser.setNickname(dto.getNickname());
        int insert = mallUserMapper.insert(mallUser);
        if(insert<=0){
            throw new RuntimeException("注册失败");
        }
        //插入成功
        return true;
    }
}
