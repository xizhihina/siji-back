package com.sijiback.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

// 获取故障信息的响应体
@Data
public class FaultResponse {
    private int statusCode;//返回状态码
    private String statusMsg;//返回状态描述
    private List<FaultResponse.FaultWithDetails> faults;//返回结果集

    public FaultResponse(int statusCode, String statusMsg, List<FaultResponse.FaultWithDetails> faults) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.faults = faults;
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
        private String level;
        private String phoneNumber;
    }
}
