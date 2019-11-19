package com.example.foodie.service;

import com.example.foodie.bean.User;


public interface UserService {
    /**
     *  登陆接口
      * @param userName
     * @param password
     * @return
     */
    User login(String userName, String password);

    void register(User user);
}
