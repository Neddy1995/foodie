package com.example.foodie.bean;

import java.util.Date;

public class AuditArticle {
    private String auditArticleId;

    private String articleId;

    private String auditText;

    private String userId;

    private Date auditTime;

    public String getAuditArticleId() {
        return auditArticleId;
    }

    public void setAuditArticleId(String auditArticleId) {
        this.auditArticleId = auditArticleId == null ? null : auditArticleId.trim();
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getAuditText() {
        return auditText;
    }

    public void setAuditText(String auditText) {
        this.auditText = auditText == null ? null : auditText.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
}