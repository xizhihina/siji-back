package com.sijiback.controller;

import com.sijiback.dto.*;
import com.sijiback.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    // 注册用户
    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> registerUser(@RequestBody UserRegisterRequest request) {
        UserRegisterResponse response = userService.registerUser(new UserRegisterRequest(request.getUsername(), request.getPassword()));
        return ResponseEntity.ok(response);
    }

    // 用户登录
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> loginUser(@RequestBody UserLoginRequest request) {
        UserLoginResponse response = userService.loginUser(new UserLoginRequest(request.getUsername(), request.getPassword()));
        return ResponseEntity.ok(response);
    }

    // 获取用户信息
    @GetMapping
    public UserResponse getUser(int user_id) {
        return userService.getUser(user_id);
    }

    // 获取所有用户信息
    @GetMapping("/all")
    public UserAllResponse getAllUsers(@RequestParam(required = false) Integer user_id, @RequestParam(required = false) String username, @RequestParam(required = false) String token){
        return userService.getAllUsers(user_id==null?0:user_id, username,token);
    }

    // 更新用户信息
    @PostMapping("/update")
    public UserUpdateResponse updateUser(@RequestBody UserUpdateRequest request) {
        return userService.updateUser(request);
    }
}

