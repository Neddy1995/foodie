package com.example.foodie.bean;

import java.util.Date;

public class DataBean {
    private int type; //1,点赞表；2，评论表；3，关注表；4，文章表创建数；5，文章表通过审核数；6，文章表审核数
    private Date dates;
    private int num;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getDate() {
        return dates;
    }

    public void setDate(Date date) {
        this.dates = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "type=" + type +
                ", dates=" + dates +
                ", num=" + num +
                '}';
    }
}
