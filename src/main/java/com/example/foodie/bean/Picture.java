package com.example.foodie.bean;

public class Picture {
    private Integer imgId;

    private String imgPath;

    private String imgName;

    private Integer imgUser;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }

    public Integer getImgUser() {
        return imgUser;
    }

    public void setImgUser(Integer imgUser) {
        this.imgUser = imgUser;
    }
}