package com.sijiback.dto;
import lombok.Data;

// 返回故障创建结果的响应类
@Data
public class FaultCreateResponse {
    private int statusCode;//返回状态码
    private String statusMsg;//返回状态信息

    public FaultCreateResponse(int statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }
}
