package com.sijiback.dto;

import lombok.Data;

//用户登录请求体
// 根据username和password进行登录
@Data
public class UserLoginRequest {
    private String username;//输入要登录的用户名
    private String password;//输入要登录的密码
    public UserLoginRequest(String username, String password) {

        this.username = username;

        this.password = password;
    }
}
