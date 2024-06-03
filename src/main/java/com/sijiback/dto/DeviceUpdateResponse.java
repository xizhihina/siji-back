package com.sijiback.dto;

import lombok.Data;

// 设备更新响应类
@Data
public class DeviceUpdateResponse {
    private int status_code;//返回状态码
    private String status_msg;//返回状态描述
}
