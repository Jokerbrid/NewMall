package com.mall.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class MallAuthApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    void Test() {
        String mm="admin";
        System.out.println(passwordEncoder.encode(mm));
    }

}
