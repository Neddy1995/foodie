package com.example.foodie.dao;

import com.example.foodie.bean.ArticlePicture;

public interface ArticlePictureMapper {
    int deleteByPrimaryKey(String articlePictureId);

    int insert(ArticlePicture record);

    int insertSelective(ArticlePicture record);

    ArticlePicture selectByPrimaryKey(String articlePictureId);

    int updateByPrimaryKeySelective(ArticlePicture record);

    int updateByPrimaryKey(ArticlePicture record);

    void deleteByaArticleId(String articleId);
}