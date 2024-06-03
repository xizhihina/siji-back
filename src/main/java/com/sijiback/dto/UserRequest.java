package com.sijiback.dto;

import lombok.Data;

// 获取用户信息请求类
// 根据输入的用户id获取用户信息
@Data
public class UserRequest {
    private int user_id;//输入要获取的用户id
    private String token;//输入要获取的用户token
}
