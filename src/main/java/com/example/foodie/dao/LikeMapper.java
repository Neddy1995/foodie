package com.example.foodie.dao;

import com.example.foodie.bean.Like;

public interface LikeMapper {
    int deleteByPrimaryKey(String likeId);

    int insert(Like record);

    int insertSelective(Like record);

    Like selectByPrimaryKey(String likeId);

    int updateByPrimaryKeySelective(Like record);

    int updateByPrimaryKey(Like record);
}