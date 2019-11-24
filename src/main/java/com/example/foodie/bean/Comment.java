package com.example.foodie.bean;

import java.util.Date;

public class Comment {
    private String commentId;

    private String articleId;

    private String userId;

    private String commentText;

    private Date commentTime;
    public Comment(){

    }

    public Comment(String articleId, String userId, String commentText) {
        this.articleId = articleId;
        this.userId = userId;
        this.commentText = commentText;
    }

    public Comment(String commentId, String articleId, String userId, String commentText) {
        this.commentId = commentId;
        this.articleId = articleId;
        this.userId = userId;
        this.commentText = commentText;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
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

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText == null ? null : commentText.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", articleId='" + articleId + '\'' +
                ", userId='" + userId + '\'' +
                ", commentText='" + commentText + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }
}