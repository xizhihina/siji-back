package com.sijiback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sijiback.model.Device;
import com.sijiback.dto.DeviceResponse.DeviceWithOwner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeviceMapper extends BaseMapper<Device> {

    // 查询设备列表，支持根据设备名称、状态、所属用户、地址、电话号码进行筛选
    @Select("<script>" +
            "SELECT d.id AS deviceId, d.name AS deviceName, d.status AS deviceStatus, " +
            "u.id AS userId, u.username AS owner, u.address, u.phone_number AS phoneNumber, u.avatar, u.level " +
            "FROM device d " +
            "LEFT JOIN user u ON d.user_id = u.id " +
            "WHERE 1=1 " +
            "<if test='id != null'>AND d.id = #{id}</if> " +
            "<if test='name != null'>AND d.name = #{name}</if> " +
            "<if test='status != null'>AND d.status = #{status}</if> " +
            "<if test='owner != null'>AND u.username = #{owner}</if> " +
            "<if test='address != null'>AND u.address = #{address}</if> " +
            "<if test='phoneNumber != null'>AND u.phone_number = #{phoneNumber}</if> " +
            "</script>")
    List<DeviceWithOwner> getDevicesByUserDetails(@Param("id") Long id,
                                                  @Param("name") String name,
                                                  @Param("status") String status,
                                                  @Param("owner") String owner,
                                                  @Param("address") String address,
                                                  @Param("phoneNumber") String phoneNumber);
}
