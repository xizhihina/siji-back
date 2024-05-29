package com.sijiback.dto;

import lombok.Data;
import java.util.List;

// 获取设备信息响应体
@Data
public class DeviceResponse {
    private int statusCode;    // 返回状态码
    private String statusMsg;  // 返回状态描述
    private List<DeviceWithOwner> devices;  // 返回设备列表

    public DeviceResponse(int statusCode, String statusMsg, List<DeviceWithOwner> devices) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.devices = devices;
    }

    // 详细设备信息响应体
    @Data
    public static class DeviceWithOwner {
        private int deviceId;      // 设备ID
        private String deviceName; // 设备名称
        private String deviceStatus;// 设备状态
        private int userId;        // 用户ID
        private String owner;      // 设备拥有者
        private String address;    // 设备地址
        private String avatar;     // 用户头像
        private String level;      // 用户权限
        private String phoneNumber;// 用户电话号码
    }
}
