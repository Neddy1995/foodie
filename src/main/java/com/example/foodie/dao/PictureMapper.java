package com.example.foodie.dao;

import com.example.foodie.bean.Picture;

public interface PictureMapper {
    int deleteByPrimaryKey(String imgId);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(String imgId);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}