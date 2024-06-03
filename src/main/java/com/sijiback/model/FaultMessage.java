package com.sijiback.model;

import lombok.Data;

@Data
public class FaultMessage {
    private int id;
    private DeviceMessage device;
    private String description;
    private String status;
    private String create_time;

    public FaultMessage(int id, DeviceMessage device, String description, String status, String create_time) {
        this.id = id;
        this.device = device;
        this.description = description;
        this.status = status;
        this.create_time = create_time;
    }
}
