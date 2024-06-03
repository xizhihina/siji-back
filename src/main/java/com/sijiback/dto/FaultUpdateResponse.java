package com.sijiback.dto;
import lombok.Data;

// 返回故障更新结果的响应体
@Data
public class FaultUpdateResponse {
    private int status_code;//返回状态码
    private String status_msg;//返回状态描述
    public FaultUpdateResponse(int statusCode, String statusMsg) {
        this.status_code = statusCode;
        this.status_msg = statusMsg;
    }
}
