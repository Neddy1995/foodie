package com.example.foodie.bean;

import java.util.Date;

public class Article {
    private Integer articleId;

    private String articleTitle;

    private String articleText;

    private Integer author;

    private Date createTime;

    private String tagging;

    private Integer articlePlace;

    private Integer state;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText == null ? null : articleText.trim();
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTagging() {
        return tagging;
    }

    public void setTagging(String tagging) {
        this.tagging = tagging == null ? null : tagging.trim();
    }

    public Integer getArticlePlace() {
        return articlePlace;
    }

    public void setArticlePlace(Integer articlePlace) {
        this.articlePlace = articlePlace;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}