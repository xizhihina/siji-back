package com.sijiback.dto;

import lombok.Data;

//用户注册请求体
// 根据username和password注册新的用户
@Data
public class UserRegisterRequest {
    private String username;//注册使用的用户名
    private String password;//注册使用的密码

    public UserRegisterRequest(String username, String password) {
        this.username = username;
        this.password =  password;
    }
}
