package com.sijiback.service;

import com.sijiback.dto.*;
import com.sijiback.mapper.UserMapper;
import com.sijiback.model.User;
import com.sijiback.model.UserMessage;
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
    // 根据username和password注册新的用户
    public UserRegisterResponse registerUser(UserRegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        // 使用md5加密密码
        user.setPassword(DigestUtils.md5DigestAsHex(request.getPassword().getBytes()));
        user.setToken(generateToken(user.getId(), user.getPassword()));
        userMapper.insert(user);

        UserRegisterResponse response = new UserRegisterResponse();
        // 注册成功
        response.setStatusCode(0);
        response.setStatusMsg("注册成功");
        response.setUserId(user.getId());
        response.setToken(user.getToken());
        return response;
    }

    /**
     * 用户登录
     */
    // 根据username和password进行登录
    public UserLoginResponse loginUser(UserLoginRequest request) {
        // 使用md5加密输入的密码
        String encryptedPassword = DigestUtils.md5DigestAsHex(request.getPassword().getBytes());
        User user = userMapper.selectByUsernameAndPassword(request.getUsername(), encryptedPassword);
        UserLoginResponse response = new UserLoginResponse();
        System.out.println(user);
        if (user != null) {
            // 登录成功，生成token
            response.setStatusCode(0);
            response.setStatusMsg("登录成功");
            response.setUserId(user.getId());
            response.setToken(user.getToken());  // 使用用户表中的token
        } else {
            // 登录失败
            response.setStatusCode(1);
            response.setStatusMsg("登录失败，用户名或密码错误");
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

    /**
     * 获取用户信息
     */
    // 根据输入的用户id获取用户信息
    public UserResponse getUser(int id) {

        // 查询数据库
        User _user = userMapper.selectById(id);
        UserMessage user;

        // 转换为UserMessage
        if (_user != null)
            user = userMapper.selectById(id).ToUserMessage();
        else
            user = null;

        UserResponse response = new UserResponse();

        if (user != null) {
            // 如果用户存在，返回用户信息
            response.setStatusCode(0);
            response.setStatusMsg("Success");
            response.setUser(user);
        } else {
            // 如果用户不存在，返回错误信息
            response.setStatusCode(1);
            response.setStatusMsg("User not found");
        }

        return response;
    }
}
