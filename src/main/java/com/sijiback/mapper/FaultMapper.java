package com.sijiback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sijiback.model.*;
import com.sijiback.dto.FaultRequest;
import com.sijiback.dto.FaultResponse.FaultWithDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FaultMapper extends BaseMapper<Fault> {

    // 查询故障列表
    @Select("<script>" +
            "SELECT f.id AS faultId, f.description AS faultDescription, f.status AS faultStatus, f.create_time AS faultCreateTime, " +
            "d.id AS deviceId, d.name AS deviceName, d.status AS deviceStatus, " +
            "u.id AS userId, u.username AS owner, u.address, u.phone_number AS phoneNumber, u.avatar, u.level " +
            "FROM fault f " +
            "LEFT JOIN device d ON f.device_id = d.id " +
            "LEFT JOIN user u ON d.user_id = u.id " +
            "WHERE 1=1 " +
            "<if test='id != null'>AND d.id = #{id}</if> " +
            "<if test='name != null'>AND d.name = #{name}</if> " +
            "<if test='status != null'>AND d.status = #{status}</if> " +
            "<if test='owner != null'>AND u.username = #{owner}</if> " +
            "<if test='address != null'>AND u.address = #{address}</if> " +
            "<if test='phoneNumber != null'>AND u.phone_number = #{phoneNumber}</if> " +
            "</script>")
    List<FaultWithDetails> getFaultsByUserDetails(@Param("id") Long id,
                                                  @Param("name") String name,
                                                  @Param("status") String status,
                                                  @Param("owner") String owner,
                                                  @Param("address") String address,
                                                  @Param("phoneNumber") String phoneNumber);
}
