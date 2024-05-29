// Service
package com.sijiback.service;

import com.sijiback.dto.*;
import com.sijiback.mapper.FaultMapper;
import com.sijiback.mapper.UserMapper;
import com.sijiback.model.Fault;
import com.sijiback.model.User;
import com.sijiback.model.WorkOrder;
import com.sijiback.mapper.WorkOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class WorkOrderService {

    @Autowired
    private WorkOrderMapper workOrderMapper;
    @Autowired
    private FaultMapper faultMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DeviceService deviceService;

    // 创建工单
    // 根据请求中的fault_id和maintenance_person_id检查是否存在对应的故障和维修人员，存在则创建工单
    public WorkOrderCreateResponse createWorkOrder(WorkOrderCreateRequest request) {
        WorkOrderCreateResponse response = new WorkOrderCreateResponse();
        try {
            // 检查fault_id是否存在
            Fault fault = faultMapper.selectById(request.getFaultId());
            if (fault == null) {
                response.setStatusCode(1);
                response.setStatusMsg("Fault ID not found");
                return response;
            }

            // 检查maintenance_person_id是否存在
            User user = userMapper.selectById(request.getMaintenancePersonId());
            if (user == null) {
                response.setStatusCode(1);
                response.setStatusMsg("Maintenance person ID not found");
                return response;
            }

            // 创建工单
            WorkOrder workOrder = new WorkOrder();
            workOrder.setMaintenancePersonId(request.getMaintenancePersonId());
            workOrder.setFaultId(request.getFaultId());
            workOrder.setMaintenanceTime(LocalDateTime.now());
            workOrder.setWorkOrderStatus("1"); // 1表示维修中,2表示维修完成
            int rows = workOrderMapper.insert(workOrder);

            if (rows > 0) {
                // 创建成功
                response.setStatusCode(0);
                response.setStatusMsg("Success");
            } else {
                // 创建失败
                response.setStatusCode(1);
                response.setStatusMsg("Failed to create work order");
            }
        } catch (Exception e) {
            // 如果try块中的代码抛出异常，则执行以下代码
            response.setStatusCode(1);
            response.setStatusMsg("Failed to create work order");
        }
        return response;
    }

    // 更新工单状态
    // 根据fault_id与work_order_id查找对应的工单，然后更新maintenanceTime、workOrderStatus、maintenancePersonId
    public WorkOrderUpdateStatusResponse updateWorkOrderStatus(WorkOrderUpdateStatusRequest request) {
        WorkOrderUpdateStatusResponse response = new WorkOrderUpdateStatusResponse();
        try {
            // 检查fault_id是否存在
            Fault fault = faultMapper.selectById(request.getFaultId());
            if (fault == null) {
                response.setStatusCode(1);
                response.setStatusMsg("Fault ID not found");
                return response;
            }

            // 检查工单是否存在
            WorkOrder workOrder = workOrderMapper.selectById(request.getWorkOrderId());
            if (workOrder == null) {
                response.setStatusCode(1);
                response.setStatusMsg("Work order not found");
                return response;
            }

            // 检查工单是否与故障关联
            if (workOrder.getFaultId() == null || !workOrder.getFaultId().equals(request.getFaultId())) {
                response.setStatusCode(1);
                response.setStatusMsg("Work order is not associated with the fault");
                return response;
            }

            // 检查maintenance_person_id是否存在
            User user = userMapper.selectById(request.getMaintenancePersonId());
            if (user == null) {
                response.setStatusCode(1);
                response.setStatusMsg("Maintenance person ID not found");
                return response;
            }

            // 更新工单状态
            workOrder.setWorkOrderStatus(String.valueOf(request.getWorkOrderStatus()));
            workOrder.setMaintenancePersonId(request.getMaintenancePersonId());
            workOrder.setMaintenanceTime(LocalDateTime.parse(String.valueOf(LocalDateTime.now())));
            int rows = workOrderMapper.updateById(workOrder);

            if (rows > 0) {
                // 更新成功
                response.setStatusCode(0);
                response.setStatusMsg("Success");
            }
            else {
                // 更新失败
                response.setStatusCode(1);
                response.setStatusMsg("Failed to update work order status");
            }
        } catch (Exception e) {
            // 如果try块中的代码抛出异常，则执行以下代码
            response.setStatusCode(1);
            response.setStatusMsg("Failed to update work order status");
        }
        return response;
    }

    // 删除工单
    // 根据work_order_id查找对应的工单，然后删除该工单
    public WorkOrderDeleteResponse deleteWorkOrder(WorkOrderDeleteRequest request) {
        WorkOrderDeleteResponse response = new WorkOrderDeleteResponse();
        try {
            // 检查工单是否存在
            WorkOrder workOrder = workOrderMapper.selectById(request.getWorkOrderId());
            if (workOrder == null) {
                response.setStatusCode(1);
                response.setStatusMsg("Work order not found");
            }

            // 删除工单
            int rows = workOrderMapper.deleteById(request.getWorkOrderId());
            if (rows > 0) {
                // 删除成功
                response.setStatusCode(0);
                response.setStatusMsg("Success");
            } else {
                // 删除失败
                response.setStatusCode(1);
                response.setStatusMsg("Failed to delete work order");
            }
        } catch (Exception e) {
            // 如果try块中的代码抛出异常，则执行以下代码
            response.setStatusCode(1);
            response.setStatusMsg("Failed to delete work order");
        }
        return response;
    }

    // 获取工单列表
    public WorkOrderResponse getWorkOrders(WorkOrderRequest request) {
        List<WorkOrderResponse.WorkOrderDetails> workOrders = workOrderMapper.getWorkOrdersByDetails(
                request.getWorkOrderId(),
                request.getOwner(),
                request.getMaintenancePerson(),
                request.getAddress()
        );

        if (Objects.isNull(workOrders) || workOrders.isEmpty()) {
            // 没有找到工单
            return new WorkOrderResponse(1, "No work orders found for the given details", null);
        }
        return new WorkOrderResponse(0, "Success", workOrders);
    }
}
