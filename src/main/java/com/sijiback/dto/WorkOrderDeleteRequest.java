package com.sijiback.dto;

import lombok.Data;

// 删除工单请求体
// 根据work_order_id查找对应的工单，然后删除该工单
@Data
public class WorkOrderDeleteRequest {
    private int work_order_id;//输入要删除的工单ID
    private String token;//输入用户鉴权token
}
