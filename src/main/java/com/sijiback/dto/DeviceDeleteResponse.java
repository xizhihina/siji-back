package com.sijiback.dto;

import lombok.Data;

// 设备删除响应类
@Data
public class DeviceDeleteResponse {
    private int statusCode;//返回状态码
    private String statusMsg;//返回状态描述
}
