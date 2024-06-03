package com.sijiback.dto;


import com.sijiback.model.UserMessage;
import lombok.Data;

//获取用户信息响应类
@Data
public class UserResponse {
    private int status_code;//返回状态码
    private String status_msg;//返回状态描述
    private UserMessage user;//返回用户信息结构体
}