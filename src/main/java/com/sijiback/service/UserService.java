package com.sijiback.service;

import com.sijiback.dto.*;
import com.sijiback.mapper.UserMapper;
import com.sijiback.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 用户注册
     */
    public UserRegisterResponse registerUser(UserRegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        // 使用md5加密密码
        user.setPassword(DigestUtils.md5DigestAsHex(request.getPassword().getBytes()));
        user.setToken(generateToken(user.getId(), user.getPassword()));
        userMapper.insert(user);

        UserRegisterResponse response = new UserRegisterResponse();
        response.setStatusCode(0);
        response.setStatusMsg("注册成功");
        response.setUserId(user.getId());
        response.setToken(user.getToken());
        return response;
    }

    /**
     * 用户登录
     */
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

    /**
     * 生成token
     */
    private String generateToken(int id, String password){
        String tokenSignKey="asklzxlcjkasksadklasklczxkmsasdsasdzxcsadasdaczxcas";// 256bits
        Date expire_time=new Date(new Date().getTime()+1000 * 60 * 60 * 24 * 20); // 20天过期
        return Jwts.builder()
                .setExpiration(expire_time)
                .claim("id", id)
                .claim("passwordMd5", password) // 私有部分，实际上真正需要封装的信息（id和name）
                .signWith(SignatureAlgorithm.HS256, tokenSignKey) // 签名部分
                .compact();
    }

    public UserResponse getUser(int id) {
        User user = userMapper.selectById(id);
        UserResponse response = new UserResponse();

        if (user != null) {
            response.setStatusCode(0);
            response.setStatusMsg("Success");
            response.setUser(user);
        } else {
            response.setStatusCode(1);
            response.setStatusMsg("User not found");
        }

        return response;
    }
}
