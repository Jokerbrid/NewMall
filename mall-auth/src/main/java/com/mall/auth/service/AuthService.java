package com.mall.auth.service;

import com.mall.auth.model.dto.AuthUserDto;
import com.mall.auth.model.po.MallUser;

public interface AuthService {

    MallUser authenticate(AuthUserDto authUserDto);
}
