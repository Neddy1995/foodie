package com.example.foodie.service;

import com.example.foodie.bean.Article;
import com.example.foodie.bean.AuditArticle;
import com.example.foodie.vo.TitleAndPictureVo;

import java.util.List;

public interface AuditService {

    /**
     * 查询待审核文章
     * @return
     */
    List<Article> selectAuditArticle();

    /**
     * 查询已审核文章
     * @param userId
     * @return
     */
    List<Article> selectPassArticle(String userId);

    /**
     * 插入一条审核记录
     * @param auditArticle
     */
    void insertAuditArticle(AuditArticle auditArticle,String state);
}
