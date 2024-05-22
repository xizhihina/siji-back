package com.sijiback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sijiback.model.Device;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeviceMapper extends BaseMapper<Device> {
    @Select("SELECT d.* FROM device d " +
            "JOIN user u ON d.user_id = u.id " +
            "WHERE u.username = #{owner} " +
            "AND u.phone_number = #{phoneNumber}")
    List<Device> getDevicesByUserDetails(@Param("owner") String owner,
                                         @Param("address") String address,
                                         @Param("phoneNumber") String phoneNumber);
}
