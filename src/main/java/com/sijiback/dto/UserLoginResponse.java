package com.sijiback.dto;

import lombok.Data;

@Data
//登录响应类
public class UserLoginResponse {
    private int status_code;//返回状态码
    private String status_msg;//返回状态描述
    private long user_id;//返回用户id
    private String token;//返回用户token
}
