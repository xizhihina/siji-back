package com.sijiback.dto;

import lombok.Data;

// 设备新增请求体
// 根据用户id新增设备，并设置设备userId、deviceName、deviceStatus
@Data
public class DeviceCreateRequest {
    private int user_id;//输入新增设备所有者id
    private String device_name;//输入新增设备名称
    private String device_status;//输入新增设备状态
    private String token;//输入用户鉴权token
}
