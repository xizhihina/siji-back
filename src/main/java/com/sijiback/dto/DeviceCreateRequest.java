package com.sijiback.dto;

import lombok.Data;

@Data
public class DeviceCreateRequest {
    private int user_id;
    private String name;
    private String status;
    private String token;
}
