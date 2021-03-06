package com.example.foodie.dao;

import com.example.foodie.bean.AuditArticle;
import com.example.foodie.bean.DataBean;

import java.util.Date;
import java.util.List;

public interface AuditArticleMapper {
    int deleteByPrimaryKey(String auditArticleId);

    int insert(AuditArticle record);

    int insertSelective(AuditArticle record);

    AuditArticle selectByPrimaryKey(String auditArticleId);

    int updateByPrimaryKeySelective(AuditArticle record);

    int updateByPrimaryKey(AuditArticle record);

    List<DataBean> selectPassNumByDay(String dateDay);

    List<DataBean> selectPassNumByMonth(String dateMonth);

    List<DataBean> selectAuditNumByDay(String dateDay);

    List<DataBean> selectAuditNumByMonth(String dateMonth);

    List<String> selectPassArticle(String userId);
}