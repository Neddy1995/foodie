package com.example.foodie.dao;

import com.example.foodie.bean.AuditArticle;

public interface AuditArticleMapper {
    int deleteByPrimaryKey(Integer auditArticleId);

    int insert(AuditArticle record);

    int insertSelective(AuditArticle record);

    AuditArticle selectByPrimaryKey(Integer auditArticleId);

    int updateByPrimaryKeySelective(AuditArticle record);

    int updateByPrimaryKey(AuditArticle record);
}