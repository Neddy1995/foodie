package com.example.foodie.service.impl;

import com.example.foodie.bean.User;
import com.example.foodie.dao.UserMapper;
import com.example.foodie.service.UserService;
import com.example.foodie.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userName,String password) {
//        密码加密
//        password = MD5Util.MD5EncodeUtf8(password);
        User user = new User(userName,password);
//        System.out.println("username:"+userName+",password:"+password);
        User userResult=userMapper.login(user);
        if(userResult!=null){
            return userResult;
        }
        return null;
    }

    @Override
    public void register(User user) {
//        密码加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

//        设置用户类别
        user.setUserPower(1);

//        设置头像(根据性别设置默认头像)


//        插入一条用户
        userMapper.insert(user);
    }

    @Override
    public User selectById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void updateUser(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        System.out.println(""+i);
    }

    @Override
    public boolean selectPassword(String userId, String password) {
        User user = new User();
        user.setUserId(userId);
//        密码加密
        user.setPassword(MD5Util.MD5EncodeUtf8(password));
//        user.setPassword(password);

//        查询
        int i = userMapper.selectPassword(user);
        if (i == 1){
            return true;
        }
        return false;
    }

    @Override
    public void updatePassword(String userId, String passwordNow) {
        User user = new User();
        user.setUserId(userId);
        user.setPassword(passwordNow);
        userMapper.updatePassword(user);
    }


}
