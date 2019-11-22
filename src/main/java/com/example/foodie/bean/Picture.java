package com.example.foodie.bean;

public class Picture {
    private String imgId;

    private String imgPath;

    private String imgName;

    private String imgUser;

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId == null ? null : imgId.trim();
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

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
        this.imgUser = imgUser == null ? null : imgUser.trim();
    }

    @Override
    public String toString() {
        return "Picture{" +
                "imgId='" + imgId + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", imgName='" + imgName + '\'' +
                ", imgUser='" + imgUser + '\'' +
                '}';
    }
}