package com.sijiback.model;

import com.sijiback.dto.DeviceResponse;
import lombok.Data;

@Data
public class DeviceMessage {
    private int id;
    private UserMessage owner;
    private String address;
    private String device_name;
    private String device_status;

//    public DeviceMessage(DeviceResponse.DeviceWithOwner deviceWithOwner) {
//        this.id = deviceWithOwner.getDeviceId();
//        this.owner = new UserMessage(deviceWithOwner.getUserId(), deviceWithOwner.getOwner(), deviceWithOwner.getAvatar(), deviceWithOwner.getPhoneNumber());
//        this.address = deviceWithOwner.getAddress();
//        this.device_name = deviceWithOwner.getDeviceName();
//        this.device_status = deviceWithOwner.getDeviceStatus();
//    }

    public DeviceMessage(int id, UserMessage owner, String address, String device_name, String device_status) {
        this.id = id;
        this.owner = owner;
        this.address = address;
        this.device_name = device_name;
        this.device_status = device_status;
    }
}
