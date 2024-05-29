package com.sijiback.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

// 获取工单详情的响应体
@Data
public class WorkOrderResponse {
    private int statusCode;//返回状态码
    private String statusMsg;//返回状态描述
    private List<WorkOrderDetails> workOrders;//返回工单详情

    public WorkOrderResponse(int statusCode, String statusMsg, List<WorkOrderDetails> workOrders) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.workOrders = workOrders;
    }

    @Data
    public static class WorkOrderDetails {
        private Long workOrderId;
        private LocalDateTime maintenanceTime;
        private String workOrderStatus;
        private String maintenancePerson;
        private int faultId;
        private String faultDescription;
        private String faultStatus;
        private LocalDateTime faultCreateTime;
        private int deviceId;
        private String deviceStatus;
        private String deviceName;
        private int userId;
        private String owner;
        private String address;
        private String avatar;
        private String level;
        private String phoneNumber;
    }
}
