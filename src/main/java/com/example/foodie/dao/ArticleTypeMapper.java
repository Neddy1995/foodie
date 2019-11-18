package com.example.foodie.dao;

import com.example.foodie.bean.ArticleType;

public interface ArticleTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    ArticleType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);
}