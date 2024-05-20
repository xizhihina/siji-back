package com.sijiback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sijiback.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectByUsername(@Param("name") String name);
}