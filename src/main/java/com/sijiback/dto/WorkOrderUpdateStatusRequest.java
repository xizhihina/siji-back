package com.sijiback.dto;

import lombok.Data;

// 更新工单状态的请求体
// 根据faultId与workOrderId查找对应的工单，然后更新maintenanceTime、workOrderStatus、（maintenancePersonId）
@Data
public class WorkOrderUpdateStatusRequest {
    private int work_order_id;        //输入要更新的工单的ID，为更新条件
    private int fault_id;            //输入要更新的工单的故障ID，为更新条件
    private String maintenance_time; //输入要重置的工单的维修时间，为更新内容
    private int status;    //输入要重置的工单的状态，为更新内容
    private int maintenance_person_id;//输入要重置的工单的维修人员ID，为更新内容
    private String token;           //输入用户鉴权token
}
