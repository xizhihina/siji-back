package com.sijiback.dto;

import lombok.Data;

// 获取工单信息的请求体
// 根据输入的一个或多个条件，返回符合条件的工单信息
@Data
public class WorkOrderRequest {
    private Long Work_order_id;           //输入工单ID
    private String owner;               //输入设备拥有者
    private String maintenance_person;   //输入设备维修人员
    private String address;             //输入设备地址
}