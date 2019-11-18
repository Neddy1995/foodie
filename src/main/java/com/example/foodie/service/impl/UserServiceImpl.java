package com.example.foodie.service.impl;

import com.example.foodie.bean.User;
import com.example.foodie.dao.UserMapper;
import com.example.foodie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User login(String userName, String password) {
        return null;
    }

//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public User login(String userName,String password) {
//        User user=userMapper.login(userName);
//        if(user.getPassword().equals(password)){
//            return user;
//        }
//        return null;
//    }

}
