package com.sijiback.dto;

import com.sijiback.model.Device;
import lombok.Data;

import java.util.List;

@Data
public class DeviceResponse {
    private int statusCode;
    private String statusMsg;
    private List<Device> devices;

    public DeviceResponse(int statusCode, String statusMsg, List<Device> devices) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.devices = devices;
    }
}
