package com.example.foodie.dao;

import com.example.foodie.bean.DataBean;
import com.example.foodie.bean.Follow;

import java.util.Date;
import java.util.List;

public interface FollowMapper {
    int deleteByPrimaryKey(String followId);

    int insert(Follow record);

    int insertSelective(Follow record);

    Follow selectByPrimaryKey(String followId);

    int updateByPrimaryKeySelective(Follow record);

    int updateByPrimaryKey(Follow record);

    int selectFollowNum(String articleId);

    void deleteFollow(Follow follow);

    List<DataBean> selectFollowNumByDay(Date dateDay);

    List<DataBean> selectFollowNumByMonth(Date dateDay);
}