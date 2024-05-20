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
    private long id;
    @TableField("name")
    private String name;
    @TableField("follow_count")
    private Long followCount;
    @TableField("is_follow")
    private Boolean isFollow;
    @TableField("avatar")
    private String avatar;
    @TableField("background_image")
    private String backgroundImage;
    @TableField("signature")
    private String signature;

}
