package com.example.foodie.bean;

import java.util.Date;

public class AuditArticle {
    private Integer auditArticleId;

    private Integer articleId;

    private String auditText;

    private Integer userId;

    private Date auditTime;

    public Integer getAuditArticleId() {
        return auditArticleId;
    }

    public void setAuditArticleId(Integer auditArticleId) {
        this.auditArticleId = auditArticleId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getAuditText() {
        return auditText;
    }

    public void setAuditText(String auditText) {
        this.auditText = auditText == null ? null : auditText.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
}