package com.example.foodie.dao;

import com.example.foodie.bean.ArticlePicture;

public interface ArticlePictureMapper {
    int deleteByPrimaryKey(Integer articlePictureId);

    int insert(ArticlePicture record);

    int insertSelective(ArticlePicture record);

    ArticlePicture selectByPrimaryKey(Integer articlePictureId);

    int updateByPrimaryKeySelective(ArticlePicture record);

    int updateByPrimaryKey(ArticlePicture record);
}