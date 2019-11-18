package com.example.foodie.dao;

import com.example.foodie.bean.Picture;

public interface PictureMapper {
    int deleteByPrimaryKey(Integer imgId);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer imgId);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}