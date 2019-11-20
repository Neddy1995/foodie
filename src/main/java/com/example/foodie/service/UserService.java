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

    /**
     * 注册接口
     * @param user
     */
    void register(User user);

    /**
     * 查询用户信息接口
     * @param userId
     * @return
     */
    User selectById(String userId);

    /**
     * 修改用户信息接口
     * @param user
     */
    void updateUser(User user);

    /**
     * 核对密码是否正确
     * @param userId
     * @param password
     * @return
     */
    boolean selectPassword(String userId, String password);

    /**
     * 修改密码
     * @param userId
     * @param passwordNow
     */
    void updatePassword(String userId, String passwordNow);
}
