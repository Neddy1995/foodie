package com.example.foodie.vo;

import com.example.foodie.bean.Article;
import com.example.foodie.bean.Picture;

import java.util.List;

public class ArticleVo extends Article {
    List<Picture> list;

    public List<Picture> getList() {
        return list;
    }

    public void setList(List<Picture> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ArticleVo{" +
                super.toString()+
                ", list=" + list +
                '}';
    }
}
