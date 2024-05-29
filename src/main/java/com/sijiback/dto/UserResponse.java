package com.sijiback.dto;


import com.sijiback.model.User;
import com.sijiback.model.UserMessage;

//获取用户信息响应类
public class UserResponse {
    private int statusCode;//返回状态码
    private String statusMsg;//返回状态描述
    private UserMessage user;//返回用户信息结构体

    // Getters and Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public UserMessage getUser() {
        return user;
    }

    public void setUser(UserMessage user) {
        this.user = user;
    }
}