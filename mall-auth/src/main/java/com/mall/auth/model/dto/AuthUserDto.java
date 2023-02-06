package com.mall.auth.model.dto;

import com.mall.auth.model.po.MallUser;
import lombok.Data;

/***
 *用于认证的实体类
 *@author jokerBird
 *@Data create 2023-02-06 13:38
*/
@Data
public class AuthUserDto{

    private String username;
    private String password;
    private String checkcode;
    private String authType;// dir 账户密码登录， phone 手机验证码登录。

}
