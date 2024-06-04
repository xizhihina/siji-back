package com.sijiback.dto;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private int user_id;//输入要更新的用户id
    private String username;//输入要更新的用户名
    private int level;//输入要更新的用户等级
    private String phone_number;//输入要更新的用户电话号码

    private String token;
}
