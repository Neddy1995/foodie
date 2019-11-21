package com.example.foodie.dao;

import com.example.foodie.bean.Picture;

import java.util.List;

public interface PictureMapper {
    int deleteByPrimaryKey(String imgId);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(String imgId);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);

    List<Picture> selectByArticleId(String articleId);
}