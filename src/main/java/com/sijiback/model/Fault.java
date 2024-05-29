package com.sijiback.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("fault")
public class Fault {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    @TableField("description")
    private String description;
    @TableField("device_id")
    private int deviceId;
    @TableField("status")
    private String faultStatus;
    @TableField("create_time")
    private LocalDateTime createTime;
}


