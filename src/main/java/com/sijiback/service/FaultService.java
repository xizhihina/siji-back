package com.sijiback.service;

import com.sijiback.dto.*;
import com.sijiback.model.*;
import com.sijiback.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class FaultService {

    @Autowired
    private FaultMapper faultMapper;
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private UserMapper userMapper;

    // 创建故障
    // 根据设备ID检查设备是否存在，然后创建故障，并设置故障状态为“1”（未处理），并设置description为请求中的描述，时间为当前时间
    public FaultCreateResponse createFault(FaultCreateRequest request) {

        // 检查设备是否存在
        Device device = deviceMapper.selectById(request.getDeviceId());
        if (device == null) {
            return new FaultCreateResponse(1, "Invalid device_id");
        }
        // 创建故障
        Fault fault = new Fault();
        fault.setDeviceId(request.getDeviceId());
        fault.setDescription(request.getFaultDescription());
        fault.setFaultStatus("1"); // 假设故障未处理状态为“1”，故障已派单状态为“2”
        // 设置创建时间和更新时间
        fault.setCreateTime(LocalDateTime.parse(String.valueOf(LocalDateTime.now())));

        int rows = faultMapper.insert(fault);
        if (rows > 0) {
            // 创建故障成功，返回成功消息
            return new FaultCreateResponse(0, "Success");
        } else {
            // 创建故障失败，返回失败消息
            return new FaultCreateResponse(1, "Failed to create fault");
        }
    }

    // 更新故障
    // 根据故障ID与设备ID检查故障是否存在，并检查故障与设备是否匹配，然后再更新对应的description、faultStatus、createTime
    public FaultUpdateResponse updateFault(FaultUpdateRequest request) {

        // 检查设备是否存在
        Device device = deviceMapper.selectById(request.getDeviceId());
        if (device == null) {
            return new FaultUpdateResponse(1, "Invalid device_id");
        }

        // 检查故障是否存在
        Fault fault = faultMapper.selectById(request.getFaultId());
        System.out.println("request.getFault_id()");
        if (fault == null) {
            return new FaultUpdateResponse(1, "Fault not found");
        }

        // 检查故障与设备是否匹配
        if (fault.getDeviceId() != request.getDeviceId()) {
            return new FaultUpdateResponse(1, "Fault does not belong to the device");
        }

        // 更新故障信息
        fault.setFaultStatus(request.getFaultStatus());
        fault.setDescription(request.getFaultDescription());
        fault.setCreateTime(LocalDateTime.parse(String.valueOf(LocalDateTime.now())));

        int rows = faultMapper.updateById(fault);
        if (rows > 0) {
            // 更新故障成功
            return new FaultUpdateResponse(0, "Success");
        } else {
            // 更新故障失败
            return new FaultUpdateResponse(1, "Failed to update fault");
        }
    }


    // 获取故障列表
    // 根据输入的一个或多个条件（device_id、device_name、status、owner、address、phone_number）查询故障列表，并返回相应的故障信息列表
    public FaultResponse getFaults(FaultRequest request) {
        // 查询故障列表
        List<FaultResponse.FaultWithDetails> faults = faultMapper.getFaultsByUserDetails(
                request.getDeviceId(),
                request.getDeviceName(),
                request.getFaultStatus(),
                request.getOwner(),
                request.getAddress(),
                request.getPhoneNumber()
        );

        if (Objects.isNull(faults) || faults.isEmpty()) {
            // 故障记录不存在
            return new FaultResponse(1, "No faults found for the given details", null);
        }

        // 故障记录存在
        return new FaultResponse(0, "Success", faults);
    }
}
