package com.sijiback.dto;
import lombok.Data;

// 返回故障创建结果的响应类
@Data
public class FaultCreateResponse {
    private int status_code;//返回状态码
    private String status_msg;//返回状态信息

    public FaultCreateResponse(int status_code, String status_msg) {
        this.status_code = status_code;
        this.status_msg = status_msg;
    }
}
