package com.sijiback.dto;
import lombok.Data;

// 用于更新故障的请求体
// 根据故障ID与设备ID检查故障是否存在，并检查故障与设备是否匹配，然后再更新对应的description、faultStatus、createTime
@Data
public class FaultUpdateRequest {
    private int fault_id;                //输入要更新的故障的ID，为更新条件
    private int device_id;               //输入要更新的故障的设备ID，为更新条件
    private String description;    //输入要更新的故障的描述，为更新内容
    private String status;         //输入要更新的故障的状态，为更新内容
    private String create_time;     //输入要更新的故障的创建时间，为更新内容
}
