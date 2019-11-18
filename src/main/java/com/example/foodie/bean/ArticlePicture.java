package com.example.foodie.bean;

public class ArticlePicture {
    private Integer articlePictureId;

    private Integer articleId;

    private Integer pictureId;

    public Integer getArticlePictureId() {
        return articlePictureId;
    }

    public void setArticlePictureId(Integer articlePictureId) {
        this.articlePictureId = articlePictureId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }
}