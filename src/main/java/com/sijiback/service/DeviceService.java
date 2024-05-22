package com.sijiback.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sijiback.dto.*;
import com.sijiback.model.Device;
import com.sijiback.mapper.*;
import com.sijiback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;



@Service
public class DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;
    private UserMapper userMapper;

    public DeviceResponse getDevices(DeviceRequest request) {
        List<Device> devices = deviceMapper.getDevicesByUserDetails(request.getOwner(), request.getAddress(), request.getPhoneNumber());

        if (Objects.isNull(devices) || devices.isEmpty()) {
            return new DeviceResponse(1, "No devices found for the given user details", null);
        }
        return new DeviceResponse(0, "Success", devices);
    }

    public DeviceUpdateResponse updateDevice(DeviceUpdateRequest request) {
        // 进行设备更新操作
        boolean success = updateDeviceInDatabase(request);

        if (success) {
            return new DeviceUpdateResponse(0, "Success");
        } else {
            return new DeviceUpdateResponse(1, "Failed to update device");
        }
    }

    public DeviceCreateResponse createDevice(DeviceCreateRequest request) {
        // 进行设备新增操作
        boolean success = createDeviceInDatabase(request);

        if (success) {
            return new DeviceCreateResponse(0, "Success");
        } else {
            return new DeviceCreateResponse(1, "Failed to create device");
        }
    }

    public DeviceDeleteResponse deleteDevice(DeviceDeleteRequest request) {
        // 进行设备删除操作
        boolean success = deleteDeviceFromDatabase(request.getId());

        if (success) {
            return new DeviceDeleteResponse(0, "Success");
        } else {
            return new DeviceDeleteResponse(1, "Failed to delete device");
        }
    }

    // 模拟设备更新操作方法
    private boolean updateDeviceInDatabase(DeviceUpdateRequest request) {
        // 根据设备ID从数据库中获取设备信息
        Device device = deviceMapper.selectById(request.getId());
        if (device == null) {
            // 如果设备不存在，更新失败
            return false;
        }

        // 根据设备信息中的用户ID获取用户信息
        User user = userMapper.selectById(device.getUser_id());
        if (user == null) {
            // 如果用户不存在，更新失败
            return false;
        }

        // 更新设备信息
        device.setName(request.getName());
        device.setStatus(request.getStatus());

        // 调用MyBatis-Plus的更新方法更新设备信息
        int rows = deviceMapper.updateById(device);
        // 根据更新结果判断是否更新成功
        return rows > 0;
    }


    // 模拟设备新增操作方法
    private boolean createDeviceInDatabase(DeviceCreateRequest request) {
        // 创建新的设备对象并设置属性值
        Device device = new Device();
        device.setName(request.getName());
        device.setUser_id(request.getUser_id());
        device.setStatus(request.getStatus());
        // 调用MyBatis-Plus的插入方法插入新的设备信息
        int rows = deviceMapper.insert(device);
        // 根据插入结果判断是否插入成功
        return rows > 0;
    }

    // 模拟设备删除操作方法
    private boolean deleteDeviceFromDatabase(int deviceId) {
        // 根据设备ID调用MyBatis-Plus的删除方法删除设备信息
        int rows = deviceMapper.deleteById(deviceId);
        // 根据删除结果判断是否删除成功
        return rows > 0;
    }
}
