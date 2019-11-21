package com.example.foodie.bean;

import java.util.Date;

public class User {
    private String userId;

    private String userName;

    private String password;

    private Integer sex;

    private String userCity;

    private Date birthday;

    private String profilePicture;

    private Integer userPower;

    private String userProfile;

    public User() {

    }

    public User(String userName, String password) {
        this.userName=userName;
        this.password=password;
    }

    public User(String userName, String password, int sex) {
        this(userName,password);
        this.sex=sex;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Integer getUserPower() {
        return userPower;
    }

    public void setUserPower(Integer userPower) {
        this.userPower = userPower;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile == null ? null : userProfile.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", userCity=" + userCity +
                ", birthday=" + birthday +
                ", profilePicture=" + profilePicture +
                ", userPower=" + userPower +
                ", userProfile='" + userProfile + '\'' +
                '}';
    }
}