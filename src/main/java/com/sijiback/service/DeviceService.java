package com.sijiback.service;

import com.sijiback.dto.*;
import com.sijiback.model.Device;
import com.sijiback.model.User;
import com.sijiback.mapper.DeviceMapper;
import com.sijiback.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private UserMapper userMapper;

    // 新增设备
    // 根据用户id新增设备，并设置设备userId、deviceName、deviceStatus
    public DeviceCreateResponse createDevice(DeviceCreateRequest request) {
        DeviceCreateResponse response = new DeviceCreateResponse();
        try {
            // 检查用户是否存在
            User user = userMapper.selectById(request.getUserId());
            if (user == null) {
                response.setStatusCode(1);
                response.setStatusMsg("Failed to create device: User not found");
                return response;
            }

            // 创建设备
            Device device = new Device();
            device.setUserId(request.getUserId());
            device.setDeviceName(request.getDeviceName());
            device.setDeviceStatus(request.getDeviceStatus());
            int rows = deviceMapper.insert(device);

            if (rows > 0) {
                // 创建成功
                response.setStatusCode(0);
                response.setStatusMsg("Success");
            } else {
                // 创建失败
                response.setStatusCode(1);
                response.setStatusMsg("Failed to create device");
            }
        } catch (Exception e) {
            // 异常处理
            response.setStatusCode(1);
            response.setStatusMsg("Failed to create device");
        }
        return response;
    }

    // 更新设备
    // 根据设备ID与用户ID查找到相应的设备，然后更新（deviceName）、deviceStatus
    public DeviceUpdateResponse updateDevice(DeviceUpdateRequest request) {
        DeviceUpdateResponse response = new DeviceUpdateResponse();
        try {
            // 检查设备是否存在
            Device device = deviceMapper.selectById(request.getDeviceId());
            if (device == null) {
                response.setStatusCode(1);
                response.setStatusMsg("Failed to update device: Device not found");
                return response;
            }

            // 检查用户是否存在
            User user = userMapper.selectById(request.getUserId());
            if (user == null) {
                response.setStatusCode(1);
                response.setStatusMsg("Failed to update device: User not found");
                return response;
            }

            // 检查设备是否属于当前用户
            if (device.getUserId() != request.getUserId()) {
                response.setStatusCode(1);
                response.setStatusMsg("Failed to update device: Device does not belong to the user");
                return response;
            }

            // 更新设备信息
            device.setDeviceName(request.getDeviceName());
            device.setDeviceStatus(request.getDeviceStatus());
            int rows = deviceMapper.updateById(device);

            if (rows > 0) {
                // 更新成功
                response.setStatusCode(0);
                response.setStatusMsg("Success");
            } else {
                // 更新失败
                response.setStatusCode(1);
                response.setStatusMsg("Failed to update device");
            }
        } catch (Exception e) {
            // 异常处理
            response.setStatusCode(1);
            response.setStatusMsg("Failed to update device");
        }
        return response;
    }

    // 删除设备
    // 根据设备ID查找相应的设备，然后删除
    public DeviceDeleteResponse deleteDevice(DeviceDeleteRequest request) {
        DeviceDeleteResponse response = new DeviceDeleteResponse();
        try {
            // 检查设备是否存在
            Device device = deviceMapper.selectById(request.getDeviceId());
            if (device == null) {
                response.setStatusCode(1);
                response.setStatusMsg("Failed to delete device: Device not found");
                return response;
            }

            // 删除设备
            int rows = deviceMapper.deleteById(request.getDeviceId());

            if (rows > 0) {
                // 删除成功
                response.setStatusCode(0);
                response.setStatusMsg("Success");
            } else {
                // 删除失败
                response.setStatusCode(1);
                response.setStatusMsg("Failed to delete device");
            }
        } catch (Exception e) {
            // 异常处理
            response.setStatusCode(1);
            response.setStatusMsg("Failed to delete device");
        }
        return response;
    }


    // 获取设备信息
    // 根据输入的一个或多个条件（设备ID、设备名称、设备状态、设备所属用户、设备地址、设备联系电话）进行查询，并返回查询结果
    public DeviceResponse getDevices(DeviceRequest request) {
        // 检查设备是否存在
        List<DeviceResponse.DeviceWithOwner> devices = deviceMapper.getDevicesByUserDetails(
                request.getDeviceId(),
                request.getDeviceName(),
                request.getDeviceStatus(),
                request.getOwner(),
                request.getAddress(),
                request.getPhoneNumber()
        );

        if (Objects.isNull(devices) || devices.isEmpty()) {
            // 设备不存在
            return new DeviceResponse(1, "No devices found for the given details", null);
        }

        // 设备存在
        return new DeviceResponse(0, "Success", devices);
    }
}
