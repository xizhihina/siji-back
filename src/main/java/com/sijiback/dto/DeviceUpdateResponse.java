package com.sijiback.dto;

import lombok.Data;

@Data
public class DeviceUpdateResponse {
    private int statusCode;
    private String statusMsg;
    public DeviceUpdateResponse(int statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }
}
