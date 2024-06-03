package com.sijiback.dto;

import lombok.Data;

@Data
public class AvatarResponse {
    private int status_code;
    private String status_msg;
    private String avatar;

    public AvatarResponse(int status_code, String status_msg, String avatar) {
        this.status_code = status_code;
        this.status_msg = status_msg;
        this.avatar = avatar;
    }
}
