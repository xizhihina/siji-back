package com.sijiback.dto;
import lombok.Data;

// 故障创建请求体
// 根据设备ID检查设备是否存在，然后创建故障，并设置故障状态为“1”（未处理），并设置description为请求中的描述，时间为当前时间
@Data
public class FaultCreateRequest {
    private int device_id;           //输入要创建的设备id
    private String fault_description;//输入故障描述
    private String token;           //输入用户鉴权token
}