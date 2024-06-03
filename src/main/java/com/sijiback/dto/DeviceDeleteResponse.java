package com.sijiback.dto;

import lombok.Data;

// 设备删除响应类
@Data
public class DeviceDeleteResponse {
    private int status_code;//返回状态码
    private String status_msg;//返回状态描述
}
