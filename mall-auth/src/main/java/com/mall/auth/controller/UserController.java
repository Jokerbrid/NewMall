package com.mall.auth.controller;

import com.mall.auth.model.dto.MallUserDto;
import com.mall.auth.model.dto.RegisterUserDto;
import com.mall.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/r")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterUserDto dto){
        userService.register(dto);
    }
    @GetMapping("/test")
    public String get(){
        return "sdasd";
    }
}
