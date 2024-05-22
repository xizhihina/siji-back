package com.sijiback.dto;

import lombok.Data;

@Data
public class DeviceCreateResponse {
    private int statusCode;
    private String statusMsg;
    public DeviceCreateResponse(int statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }
}
