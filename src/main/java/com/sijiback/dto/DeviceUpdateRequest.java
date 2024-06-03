package com.sijiback.dto;

import lombok.Data;

// 设备更新请求体
// 根据设备ID与用户ID查找到相应的设备，然后更新（deviceName）、deviceStatus
@Data
public class DeviceUpdateRequest {
    private int device_id;       //输入设备id，为更新条件
    private int user_id;         //输入设备所有者id，为更新条件
    private String device_name;  //输入要修改的设备名称，为更新内容
    private String device_status;//输入要修改的设备状态，为更新内容
    private String token;       //输入用户鉴权token
}