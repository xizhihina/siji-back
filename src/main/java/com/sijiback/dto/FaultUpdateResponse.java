package com.sijiback.dto;
import lombok.Data;

// 返回故障更新结果的响应体
@Data
public class FaultUpdateResponse {
    private int statusCode;//返回状态码
    private String statusMsg;//返回状态描述
    public FaultUpdateResponse(int statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }
}
