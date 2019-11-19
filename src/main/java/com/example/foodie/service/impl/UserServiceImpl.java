package com.example.foodie.service.impl;

import com.example.foodie.bean.User;
import com.example.foodie.dao.UserMapper;
import com.example.foodie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userName,String password) {
//        密码加密

        User user = new User(userName,password);
        System.out.println("username:"+userName+",password:"+password);
        User userResult=userMapper.login(user);
        if(userResult!=null){
            return userResult;
        }
        return null;
    }

    @Override
    public void register(User user) {

    }


}
