package com.sijiback.dto;

import lombok.Data;

// 查看故障报修记录请求体
// 根据输入的一个或多个条件（device_id、device_name、status、owner、address、phone_number）查询故障列表，并返回相应的故障信息列表
@Data
public class FaultRequest {
    private Long device_id;//输入要查的故障设备id
    private String owner;//输入要查的故障设备拥有者
    private String address;//输入要查的故障设备地址
    private String phone_number;//输入要查的故障设备拥有者电话号码
    private String device_name;//输入要查的故障设备名称
    private String fault_status;//输入要查的故障状态
}

