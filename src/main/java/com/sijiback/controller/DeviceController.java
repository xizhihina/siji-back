package com.sijiback.controller;

import com.sijiback.dto.*;
import com.sijiback.model.Device;
import com.sijiback.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public DeviceResponse getDevices(DeviceRequest deviceRequest) {
        return deviceService.getDevices(deviceRequest);
    }

    @PostMapping("/update")
    public DeviceUpdateResponse updateDevice(DeviceUpdateRequest deviceUpdateRequest) {
        return deviceService.updateDevice(deviceUpdateRequest);
    }

    @PostMapping("/add")
    public DeviceCreateResponse createDevice(DeviceCreateRequest deviceCreateRequest) {
        return deviceService.createDevice(deviceCreateRequest);
    }

    @PostMapping("/delete")
    public DeviceDeleteResponse deleteDevice(DeviceDeleteRequest deviceDeleteRequest) {
        return deviceService.deleteDevice(deviceDeleteRequest);
    }
}
