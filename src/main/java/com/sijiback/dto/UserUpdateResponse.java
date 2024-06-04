package com.sijiback.dto;

import lombok.Data;

@Data
public class UserUpdateResponse {
    private int status_code;//返回状态码
    private String status_msg;//返回状态描述
}
