package com.sijiback.controller;

import com.sijiback.dto.*;
import com.sijiback.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    // 新增设备
    @PostMapping("/add")
    public DeviceCreateResponse createDevice(DeviceCreateRequest deviceCreateRequest) {
        return deviceService.createDevice(deviceCreateRequest);
    }

    // 更新设备
    @PostMapping("/update")
    public DeviceUpdateResponse updateDevice(DeviceUpdateRequest deviceUpdateRequest) {
        return deviceService.updateDevice(deviceUpdateRequest);
    }

    // 删除设备
    @PostMapping("/delete")
    public DeviceDeleteResponse deleteDevice(DeviceDeleteRequest deviceDeleteRequest) {
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
        deviceRequest.setDeviceId(deviceId);
        deviceRequest.setOwner(owner);
        deviceRequest.setAddress(address);
        deviceRequest.setPhoneNumber(phoneNumber);
        deviceRequest.setDeviceName(deviceName);
        deviceRequest.setDeviceStatus(deviceStatus);

        return deviceService.getDevices(deviceRequest);
    }
}
