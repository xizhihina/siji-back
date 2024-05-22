package com.sijiback.dto;

import lombok.Data;

@Data
public class DeviceUpdateRequest {
    private int id;
    private int user_id;
    private String name;
    private String status;
    private String token;
}