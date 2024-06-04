package com.sijiback.dto;

import com.sijiback.model.UserMessage;
import lombok.Data;

import java.util.List;

@Data
public class UserAllResponse {
    private int status_code;//返回状态码
    private String status_msg;//返回状态描述
    private List<UserMessage> user;//返回用户信息结构体
}
