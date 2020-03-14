package com.example.foodie.vo;

import com.example.foodie.bean.Comment;

public class CommentVo extends Comment {
    private String userName;
    private String imgPath;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "CommentVo{" +
                "userName='" + userName + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
