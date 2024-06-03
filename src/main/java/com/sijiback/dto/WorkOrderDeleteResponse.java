package com.sijiback.dto;

import lombok.Data;

// 删除工单响应类
@Data
public class WorkOrderDeleteResponse {
    private int status_code;//返回状态码
    private String status_msg;//返回状态描述
}
