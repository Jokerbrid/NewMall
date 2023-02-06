package com.mall.auth.service;

import com.mall.auth.model.dto.RegisterUserDto;

public interface UserService {

    boolean register(RegisterUserDto dto);
}
