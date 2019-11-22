package com.example.foodie.bean;

import java.util.Date;

public class Article {
    private String articleId;

    private String articleTitle;

    private String articleText;

    private String author;

    private Date createTime;

    private String tagging;

    private String articlePlace;

    private Integer state;

    private String typeId;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
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

    public String getArticlePlace() {
        return articlePlace;
    }

    public void setArticlePlace(String articlePlace) {
        this.articlePlace = articlePlace == null ? null : articlePlace.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleText='" + articleText + '\'' +
                ", author='" + author + '\'' +
                ", createTime=" + createTime +
                ", tagging='" + tagging + '\'' +
                ", articlePlace='" + articlePlace + '\'' +
                ", state=" + state +
                ", typeId='" + typeId + '\'' +
                '}';
    }
}