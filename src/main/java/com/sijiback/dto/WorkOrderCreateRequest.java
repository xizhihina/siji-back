package com.sijiback.dto;

import lombok.Data;

// 创建工单请求体
// 根据请求中的faultId和maintenancePersonId检查是否存在对应的故障和维修人员，存在则创建工单
@Data
public class WorkOrderCreateRequest {
    private int maintenancePersonId;//输入维修人员ID
    private int faultId;//输入故障ID
    private String token;//输入用户鉴权token
}