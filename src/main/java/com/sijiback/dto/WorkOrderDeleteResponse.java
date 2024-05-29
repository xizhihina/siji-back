package com.sijiback.dto;

import lombok.Data;

// 删除工单响应类
@Data
public class WorkOrderDeleteResponse {
    private int statusCode;//返回状态码
    private String statusMsg;//返回状态描述
}
