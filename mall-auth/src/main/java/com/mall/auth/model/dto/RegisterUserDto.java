package com.mall.auth.model.dto;

import lombok.Data;

@Data
public class RegisterUserDto {

    private String username;//用户名 手机号/电话号/email
    private String password;//明文传递： 密文存放。

    private String nickname;//昵称
//    private String confirmPassword; 前端处理

    private String authType;//验证类型： dir/phone/emil

    private String checkcode;//邮箱验证码/手机号验证码；
}
