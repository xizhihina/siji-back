package com.sijiback.dto;

import lombok.Data;

@Data
public class DeviceDeleteResponse {
    private int statusCode;
    private String statusMsg;
    public DeviceDeleteResponse(int statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }
}
