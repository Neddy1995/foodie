package com.example.foodie.dao;

import com.example.foodie.bean.ArticleType;

public interface ArticleTypeMapper {
    int deleteByPrimaryKey(String typeId);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    ArticleType selectByPrimaryKey(String typeId);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);

    String selectByName(ArticleType articleType);
}