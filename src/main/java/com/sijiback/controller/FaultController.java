package com.sijiback.controller;

import com.sijiback.dto.*;
import com.sijiback.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fault")
public class FaultController {

    @Autowired
    private FaultService faultService;

    // 创建新的故障
    @PostMapping("/add")
    public FaultCreateResponse createFault(FaultCreateRequest faultCreateRequest) {
        return faultService.createFault(faultCreateRequest);
    }

    // 更新故障信息
    @PostMapping("/update")
    public FaultUpdateResponse updateFault(FaultUpdateRequest faultUpdateRequest) {
        return faultService.updateFault(faultUpdateRequest);
    }

    // 获取故障列表
    @GetMapping
    public FaultResponse getFaults(
            @RequestParam(required = false) Long deviceId,
            @RequestParam(required = false) String owner,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String deviceName,
            @RequestParam(required = false) String faultStatus) {

        // 创建请求对象
        FaultRequest faultRequest = new FaultRequest();
        faultRequest.setDeviceId(deviceId);
        faultRequest.setOwner(owner);
        faultRequest.setAddress(address);
        faultRequest.setPhoneNumber(phoneNumber);
        faultRequest.setDeviceName(deviceName);
        faultRequest.setFaultStatus(faultStatus);

        return faultService.getFaults(faultRequest);
    }
}
