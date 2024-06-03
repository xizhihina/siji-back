package com.sijiback.controller;

import com.sijiback.dto.*;
import com.sijiback.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/fault")
public class FaultController {

    @Autowired
    private FaultService faultService;

    // 创建新的故障
    @PostMapping("/add")
    public FaultCreateResponse createFault(@RequestBody FaultCreateRequest faultCreateRequest) {
        return faultService.createFault(faultCreateRequest);
    }

    // 更新故障信息
    @PostMapping("/update")
    public FaultUpdateResponse updateFault(@RequestBody FaultUpdateRequest faultUpdateRequest) {
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
        faultRequest.setDevice_id(deviceId);
        faultRequest.setOwner(owner);
        faultRequest.setAddress(address);
        faultRequest.setPhone_number(phoneNumber);
        faultRequest.setDevice_name(deviceName);
        faultRequest.setFault_status(faultStatus);

        return faultService.getFaults(faultRequest);
    }
}
