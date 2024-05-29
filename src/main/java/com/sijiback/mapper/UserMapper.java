package com.sijiback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sijiback.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    //根据用户名和密码查询用户是否符合登录条件
    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
