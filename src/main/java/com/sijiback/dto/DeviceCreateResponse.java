package com.sijiback.dto;

import lombok.Data;

//设备新增响应类
@Data
public class DeviceCreateResponse {
    private int status_code;//返回状态码
    private String status_msg;//返回状态描述
}
