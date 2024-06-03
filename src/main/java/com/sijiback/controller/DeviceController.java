package com.sijiback.controller;

import com.sijiback.dto.*;
import com.sijiback.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    // 新增设备
    @PostMapping("/add")
    public DeviceCreateResponse createDevice(@RequestBody DeviceCreateRequest deviceCreateRequest) {
        return deviceService.createDevice(deviceCreateRequest);
    }

    // 更新设备
    @PostMapping("/update")
    public DeviceUpdateResponse updateDevice(@RequestBody DeviceUpdateRequest deviceUpdateRequest) {
        return deviceService.updateDevice(deviceUpdateRequest);
    }

    // 删除设备
    @PostMapping("/delete")
    public DeviceDeleteResponse deleteDevice(@RequestBody DeviceDeleteRequest deviceDeleteRequest) {
        return deviceService.deleteDevice(deviceDeleteRequest);
    }

    // 获取设备信息
    @GetMapping
    public DeviceResponse getDevices(
            @RequestParam(required = false) Long deviceId,
            @RequestParam(required = false) String owner,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String deviceName,
            @RequestParam(required = false) String deviceStatus) {

        // 构造请求参数
        DeviceRequest deviceRequest = new DeviceRequest();
        deviceRequest.setDevice_id(deviceId);
        deviceRequest.setOwner(owner);
        deviceRequest.setAddress(address);
        deviceRequest.setPhone_number(phoneNumber);
        deviceRequest.setDevice_name(deviceName);
        deviceRequest.setDevice_status(deviceStatus);

        return deviceService.getDevices(deviceRequest);
    }
}
