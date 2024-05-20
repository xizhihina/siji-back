package com.sijiback.dto;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String username;
    private String password;
    public UserLoginRequest(String username, String password) {

        this.username = username;

        this.password = password;
    }
}
