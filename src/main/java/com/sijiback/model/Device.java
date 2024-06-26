package com.sijiback.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("device")
public class Device {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    @TableField("name")
    private String deviceName;
    @TableField("user_id")
    private int userId;
    @TableField("status")
    private String deviceStatus;
}