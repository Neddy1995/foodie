package com.example.foodie.vo;

import com.example.foodie.bean.Article;
import com.example.foodie.bean.Picture;

public class TitleAndPictureVo {
    private String articleId;
    private String articleTitle;
    private String imgId;
    private String imgPath;
    private String imgName;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public String toString() {
        return "TitleAndPictureVo{" +
                "articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", imgId='" + imgId + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", imgName='" + imgName + '\'' +
                '}';
    }

    /**
     * 将文章的标题名称和图片路径等放入该vo类中
     * @param article
     * @param picture
     */
    public void setArticleAndPicture(Article article, Picture picture) {
        this.setArticleId(article.getArticleId());
        this.setArticleTitle(article.getArticleTitle());
        this.setImgId(picture.getImgId());
        this.setImgPath(picture.getImgPath());
        this.setImgName(picture.getImgName());
    }
}
