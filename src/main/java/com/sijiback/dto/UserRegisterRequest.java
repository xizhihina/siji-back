package com.sijiback.dto;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String username;
    private String password;

    public UserRegisterRequest(String username, String password) {
        this.username = username;
        this.password =  password;
    }
}
