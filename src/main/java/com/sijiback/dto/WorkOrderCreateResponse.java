package com.sijiback.dto;

import lombok.Data;

// 用于封装工单创建的响应结果
@Data
public class WorkOrderCreateResponse {
    private int status_code;//返回状态码
    private String status_msg;//返回状态描述
}
