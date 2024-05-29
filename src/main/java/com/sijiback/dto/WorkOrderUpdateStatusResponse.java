package com.sijiback.dto;

import lombok.Data;

// 用于返回工单状态更新的响应信息
@Data
public class WorkOrderUpdateStatusResponse {
    private int statusCode;//返回状态码
    private String statusMsg;//返回状态描述
}
