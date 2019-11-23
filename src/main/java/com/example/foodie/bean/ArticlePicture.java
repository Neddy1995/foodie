package com.example.foodie.bean;

public class ArticlePicture {
    private String articlePictureId;

    private String articleId;

    private String pictureId;

    public ArticlePicture(){

    }

    public ArticlePicture(String articleId, String pictureId) {
        this.articleId=articleId;
        this.pictureId=pictureId;
    }

    public String getArticlePictureId() {
        return articlePictureId;
    }

    public void setArticlePictureId(String articlePictureId) {
        this.articlePictureId = articlePictureId == null ? null : articlePictureId.trim();
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId == null ? null : pictureId.trim();
    }
}