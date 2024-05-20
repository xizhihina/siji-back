package com.sijiback.controller;

import com.sijiback.dto.*;
import com.sijiback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") Long id) {
        UserRequest request = new UserRequest();
        request.setId(id);
        UserResponse response = userService.getUser(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> registerUser(@RequestParam String username, @RequestParam String password){
        UserRegisterResponse response = userService.registerUser(new UserRegisterRequest(username,password));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> loginUser(@RequestParam String username, @RequestParam String password) {
        UserLoginResponse response = userService.loginUser(new UserLoginRequest(username,password));
        return ResponseEntity.ok(response);
    }
}

