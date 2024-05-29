// Entity
package com.sijiback.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("work_order")
public class WorkOrder {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("maintenance_person_id")
    private Integer maintenancePersonId;
    @TableField("maintenance_time")
    private LocalDateTime maintenanceTime;
    @TableField("status")
    private String workOrderStatus;
    @TableField("fault_id")
    private Integer faultId;
}
