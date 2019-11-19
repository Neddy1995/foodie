package com.example.foodie.service.impl;

import com.example.foodie.bean.User;
import com.example.foodie.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void login() {
        User userResult = userService.login("1","1");
        System.out.println(""+userResult);
    }
}