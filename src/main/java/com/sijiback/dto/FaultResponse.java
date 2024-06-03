package com.sijiback.dto;

import com.sijiback.model.DeviceMessage;
import com.sijiback.model.FaultMessage;
import com.sijiback.model.UserMessage;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

// 获取故障信息的响应体
@Data
public class FaultResponse {
    private int status_code;//返回状态码
    private String status_msg;//返回状态描述
    private List<FaultMessage> fault;//返回结果集

    public FaultResponse(int statusCode, String statusMsg, List<FaultWithDetails> faults) {
        this.status_code = statusCode;
        this.status_msg = statusMsg;
        this.fault = faults.stream().map(i->new FaultMessage(i.getFaultId(),new DeviceMessage(i.getDeviceId(),new UserMessage(i.getUserId(), i.getOwner(), i.getAvatar(), i.getLevel(),i.getPhoneNumber()),i.getAddress(),i.getDeviceName(),i.getDeviceStatus()),i.getFaultDescription(),i.getFaultStatus(),i.getFaultCreateTime().toString())).toList();
    }

    @Data
    public static class FaultWithDetails {
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
