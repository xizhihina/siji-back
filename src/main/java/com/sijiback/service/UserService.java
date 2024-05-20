package com.sijiback.service;

import com.sijiback.dto.*;
import com.sijiback.mapper.UserMapper;
import com.sijiback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserResponse getUser(UserRequest request) {
        User user = userMapper.selectById(request.getId());
        UserResponse response = new UserResponse();
        if (user != null) {
            response.setStatusCode(0);
            response.setStatusMsg("成功");
            response.setUser(user);
        } else {
            response.setStatusCode(1);
            response.setStatusMsg("用户未找到");
        }
        return response;
    }

    public UserRegisterResponse registerUser(UserRegisterRequest request) {
        User user = new User();
        user.setName(request.getUsername());
        user.setIsFollow(false);
        userMapper.insert(user);

        UserRegisterResponse response = new UserRegisterResponse();
        response.setStatusCode(0);
        response.setStatusMsg("注册成功");
        response.setUserId(user.getId());
        response.setToken("dummy-token");
        return response;
    }

    public UserLoginResponse loginUser(UserLoginRequest request) {
        User user = userMapper.selectById(request.getUsername());
        UserLoginResponse response = new UserLoginResponse();
        if (user != null) {
            response.setStatusCode(0);
            response.setStatusMsg("登录成功");
            response.setUserId(user.getId());
            response.setToken("dummy-token");
        } else {
            response.setStatusCode(1);
            response.setStatusMsg("登录失败，用户不存在");
        }
        return response;
    }
}
