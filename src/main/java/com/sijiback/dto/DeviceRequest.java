package com.sijiback.dto;

import lombok.Data;

// 获取设备信息请求体
// 根据输入的一个或多个条件（设备ID、设备名称、设备状态、设备所属用户、设备地址、设备联系电话）进行查询，并返回查询结果
@Data
public class DeviceRequest {
    private Long deviceId;//输入设备ID
    private String owner;//输入设备拥有者
    private String address;//输入设备地址
    private String phoneNumber;//输入电话号码
    private String deviceName;//输入设备名称
    private String deviceStatus;//输入设备状态
}
