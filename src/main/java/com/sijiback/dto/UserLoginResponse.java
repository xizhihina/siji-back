package com.sijiback.dto;

import lombok.Data;

@Data
//登录响应类
public class UserLoginResponse {
    private int statusCode;//返回状态码
    private String statusMsg;//返回状态描述
    private long userId;//返回用户id
    private String token;//返回用户token
}
