package com.example.foodie.bean;

import java.util.Date;

public class Like {
    private String likeId;

    private String articleId;

    private String userId;

    private Date likeTime;

    public Like() {
    }

    public Like(String articleId, String userId, Date likeTime) {
        this.articleId = articleId;
        this.userId = userId;
        this.likeTime = likeTime;
    }

    public String getLikeId() {
        return likeId;
    }

    public void setLikeId(String likeId) {
        this.likeId = likeId == null ? null : likeId.trim();
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(Date likeTime) {
        this.likeTime = likeTime;
    }
}