// Controller
package com.sijiback.controller;

import com.sijiback.dto.*;
import com.sijiback.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/work_order")
public class WorkOrderController {

    @Autowired
    private WorkOrderService workOrderService;

    // 创建工单
    @PostMapping("/create")
    public WorkOrderCreateResponse createWorkOrder(WorkOrderCreateRequest request) {
        return workOrderService.createWorkOrder(request);
    }

    // 更新工单状态
    @PostMapping("/update")
    public WorkOrderUpdateStatusResponse updateWorkOrderStatus(WorkOrderUpdateStatusRequest request) {
        return workOrderService.updateWorkOrderStatus(request);
    }

    // 删除工单
    @PostMapping("/delete")
    public WorkOrderDeleteResponse deleteWorkOrder(WorkOrderDeleteRequest request) {
        return workOrderService.deleteWorkOrder(request);
    }

    // 获取工单列表
    @GetMapping
    public WorkOrderResponse getWorkOrders(
            @RequestParam(required = false) Long workOrderId,
            @RequestParam(required = false) String owner,
            @RequestParam(required = false) String maintenancePerson,
            @RequestParam(required = false) String address) {

        // 构造请求参数
        WorkOrderRequest workOrderRequest = new WorkOrderRequest();
        workOrderRequest.setWorkOrderId(workOrderId);
        workOrderRequest.setOwner(owner);
        workOrderRequest.setMaintenancePerson(maintenancePerson);
        workOrderRequest.setAddress(address);

        return workOrderService.getWorkOrders(workOrderRequest);
    }
}
