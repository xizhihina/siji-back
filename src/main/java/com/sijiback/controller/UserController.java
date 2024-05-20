package com.sijiback.controller;

import com.sijiback.dto.*;
import com.sijiback.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> registerUser(UserRegisterRequest request) {
        UserRegisterResponse response = userService.registerUser(new UserRegisterRequest(request.getUsername(), request.getPassword()));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> loginUser(UserLoginRequest request) {
        UserLoginResponse response = userService.loginUser(new UserLoginRequest(request.getUsername(), request.getPassword()));
        return ResponseEntity.ok(response);
    }
}

