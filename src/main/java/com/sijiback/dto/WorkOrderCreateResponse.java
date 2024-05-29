package com.sijiback.dto;

import lombok.Data;

// 用于封装工单创建的响应结果
@Data
public class WorkOrderCreateResponse {
    private int statusCode;//返回状态码
    private String statusMsg;//返回状态描述
}
