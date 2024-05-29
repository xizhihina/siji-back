package com.sijiback.controller;

import com.sijiback.dto.*;
import com.sijiback.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    // 注册用户
    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> registerUser(UserRegisterRequest request) {
        UserRegisterResponse response = userService.registerUser(new UserRegisterRequest(request.getUsername(), request.getPassword()));
        return ResponseEntity.ok(response);
    }

    // 用户登录
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> loginUser(UserLoginRequest request) {
        UserLoginResponse response = userService.loginUser(new UserLoginRequest(request.getUsername(), request.getPassword()));
        return ResponseEntity.ok(response);
    }

    // 获取用户信息
    @GetMapping
    public UserResponse getUser(int userId) {
        return userService.getUser(userId);
    }
}

