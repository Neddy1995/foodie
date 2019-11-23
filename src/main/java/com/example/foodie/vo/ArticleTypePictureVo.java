package com.example.foodie.vo;

import com.example.foodie.bean.Article;
import com.example.foodie.bean.ArticleType;

import java.util.List;

public class ArticleTypePictureVo {

    private Article article;

    private ArticleType articleType;

    private List<String> list;

    public ArticleTypePictureVo() {
    }

    public ArticleTypePictureVo(Article article, ArticleType articleType, List<String> list) {
        this.article = article;
        this.articleType = articleType;
        this.list = list;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
