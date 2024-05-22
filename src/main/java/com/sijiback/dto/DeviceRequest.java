package com.sijiback.dto;

import lombok.Data;

@Data
public class DeviceRequest {
    private long id;
    private String owner;
    private String address;
    private String phoneNumber;
    private String name;
    private String status;
}
