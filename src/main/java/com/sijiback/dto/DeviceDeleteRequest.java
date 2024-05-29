package com.sijiback.dto;

import lombok.Data;

// 设备删除请求体
// 根据设备ID查找相应的设备，然后删除
@Data
public class DeviceDeleteRequest {
    private int deviceId;//输入设备id
    private String token;//输入用户鉴权token
}
