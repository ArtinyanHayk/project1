package com.example.chat_app2.model;

import com.google.firebase.Timestamp;

public class UserModel {
    private String phone;
    private String userName;
    private Timestamp createdTimesetap;
    private String userId;

    public UserModel() {
    }

    public UserModel(String phone, String userName, Timestamp createdTimesetap,String userId) {
        this.phone = phone;
        this.userName = userName;
        this.createdTimesetap = createdTimesetap;
        this.userId =  userId;

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getCreatedTimesetap() {
        return createdTimesetap;
    }

    public void setCreatedTimesetap(Timestamp createdTimesetap) {
        this.createdTimesetap = createdTimesetap;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
