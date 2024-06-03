package com.sijiback.dto;

import com.sijiback.model.DeviceMessage;
import com.sijiback.model.FaultMessage;
import com.sijiback.model.UserMessage;
import com.sijiback.model.WorkOrderMessage;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

// 获取工单详情的响应体
@Data
public class WorkOrderResponse {
    private int status_code;//返回状态码
    private String status_msg;//返回状态描述
    private List<WorkOrderMessage> work_order;//返回工单详情

    public WorkOrderResponse(int statusCode, String statusMsg, List<WorkOrderDetails> workOrders) {
        this.status_code = statusCode;
        this.status_msg = statusMsg;
        this.work_order = workOrders.stream().map(i -> new WorkOrderMessage(
                i.workOrderId,i.maintenanceTime.toString(),i.workOrderStatus,
//                new UserMessage(i.userId, i.maintenancePerson,i.avatar,i.level,i.phoneNumber),
                new UserMessage(i.maintenancePersonId, i.maintenancePersonName,null,0,null),//维修人员信息
                new FaultMessage(i.faultId,
                        new DeviceMessage(i.deviceId,
                                new UserMessage(i.getUserId(), i.getOwner(),i.getAvatar(),i.getLevel(),i.getPhoneNumber()),
                                i.getAddress(),i.getDeviceName(),i.getDeviceStatus()
                        ),i.getFaultDescription(),i.getFaultStatus(),i.getFaultCreateTime().toString()
                ))).toList();
    }

    @Data
    public static class WorkOrderDetails {
        private int workOrderId;
        private LocalDateTime maintenanceTime;
        private int workOrderStatus;
        private int maintenancePersonId;
        private String maintenancePersonName;
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
        private int level;
        private String phoneNumber;
    }
}
