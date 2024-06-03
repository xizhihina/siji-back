package com.sijiback.model;

import lombok.Data;

@Data
public class UserMessage {
    private int id;
    private String name;
    private String avatar;
    private int level;
    private String phone_number;

    public UserMessage(int id, String username, String avatar,int level, String phone_number) {
        this.id = id;
        this.name = username;
        this.avatar = avatar;
        this.level = level;
        this.phone_number = phone_number;
    }
}
