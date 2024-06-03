// Mapper
package com.sijiback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sijiback.dto.WorkOrderResponse;
import com.sijiback.model.WorkOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorkOrderMapper extends BaseMapper<WorkOrder> {

    // 查询工单列表
    @Select("<script>" +
            "SELECT wo.id AS workOrderId, wo.maintenance_time AS maintenanceTime, wo.status AS workOrderStatus, " +
            "u1.username AS maintenancePersonName, " + "u1.id AS maintenancePersonId, " +
            "f.id AS faultId, f.description AS faultDescription, f.status AS faultStatus, f.create_time AS faultCreateTime, " +
            "d.id AS deviceId, d.status AS deviceStatus, d.name AS deviceName, " +
            "u2.id AS userId, u2.username AS owner, u2.address, u2.avatar, u2.level, u2.phone_number AS phoneNumber " +
            "FROM work_order wo " +
            "LEFT JOIN fault f ON wo.fault_id = f.id " +
            "LEFT JOIN device d ON f.device_id = d.id " +
            "LEFT JOIN user u1 ON wo.maintenance_person_id = u1.id " +
            "LEFT JOIN user u2 ON d.user_id = u2.id " +
            "WHERE 1=1 " +
            "<if test='workOrderId != null'>AND wo.id = #{workOrderId}</if> " +
            "<if test='owner != null'>AND u2.username = #{owner}</if> " +
            "<if test='maintenancePerson != null'>AND u1.username = #{maintenancePerson}</if> " +
            "<if test='address != null'>AND u2.address = #{address}</if> " +
            "</script>")
    List<WorkOrderResponse.WorkOrderDetails> getWorkOrdersByDetails(@Param("workOrderId") Long workOrderId,
                                                                    @Param("owner") String owner,
                                                                    @Param("maintenancePerson") String maintenancePerson,
                                                                    @Param("address") String address);
}
