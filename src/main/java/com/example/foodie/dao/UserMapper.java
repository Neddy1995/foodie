package com.example.foodie.dao;

import com.example.foodie.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(User user);

    User selectByUserName(String userName);

    int selectPassword(User user);

    void updatePassword(User user);
}