package com.sijiback.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("user")
@Data
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("token")
    private String token;
    @TableField("level")
    private String level;
    @TableField("phone_number")
    private String phone_number;
    @TableField("address")
    private String address;
}
