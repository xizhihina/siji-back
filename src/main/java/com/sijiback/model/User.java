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
    private int level;
    @TableField("phone_number")
    private String phoneNumber;
    @TableField("address")
    private String address;
    @TableField("avatar")
    private String avatar;

    public UserMessage ToUserMessage() {
        return new UserMessage(this.id, this.username, this.avatar,this.level, this.phoneNumber);
    }
}
