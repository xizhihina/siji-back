package com.sijiback.dto;

import com.sijiback.model.DeviceMessage;
import com.sijiback.model.UserMessage;
import lombok.Data;
import java.util.List;

// 获取设备信息响应体
@Data
public class DeviceResponse {
    private int status_code;    // 返回状态码
    private String status_msg;  // 返回状态描述
    private List<DeviceMessage> device_list;  // 返回设备列表

    public DeviceResponse(int status_code, String status_msg, List<DeviceWithOwner> devices) {
        this.status_code = status_code;
        this.status_msg = status_msg;
        this.device_list = devices.stream().map(i -> new DeviceMessage(i.getDeviceId(),
                new UserMessage(i.getUserId(), i.getOwner(), i.getAvatar(),i.getLevel(), i.getPhoneNumber())
                ,i.getAddress(),i.getDeviceName(),i.deviceStatus)).toList();
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
        private int level;      // 用户权限
        private String phoneNumber;// 用户电话号码
    }
}
