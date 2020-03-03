package com.example.foodie.dao;

import com.example.foodie.bean.Article;
import com.example.foodie.bean.DataBean;

import java.util.Date;
import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(String articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> selectByStreetId(String streetId);

    List<Article> selectByTypeId(String typeId);

    List<Article> selectByText(String text);

    List<Article> selectByComment(List<String> listComment);

    List<DataBean> selectArticleNumByDay(String dateDay);

    List<DataBean> selectArticleNumByMonth(String dateMonth);

    List<Article> selectAuditArticle();

    List<Article> selectPassArticle(List<String> listArticleId);

    List<Article> selectByUserId(String userId);
}