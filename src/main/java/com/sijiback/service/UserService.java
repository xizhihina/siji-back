package com.sijiback.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sijiback.dto.*;
import com.sijiback.mapper.UserMapper;
import com.sijiback.model.User;
import com.sijiback.model.UserMessage;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.Wrapper;
import java.util.Date;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 用户注册
     */
    // 根据username和password注册新的用户
//    public UserRegisterResponse registerUser(UserRegisterRequest request) {
    public UserRegisterResponse registerUser(UserRegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        // 使用md5加密密码
        user.setPassword(DigestUtils.md5DigestAsHex(request.getPassword().getBytes()));
        user.setToken(generateToken(user.getId(), user.getPassword()));
        System.out.println(user);
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            // 注册失败
            UserRegisterResponse response = new UserRegisterResponse();
            response.setStatus_code(1);
            response.setStatus_msg("注册失败，用户名已存在");
            return response;
        }

        UserRegisterResponse response = new UserRegisterResponse();
        // 注册成功
        response.setStatus_code(0);
        response.setStatus_msg("注册成功");
        response.setUser_id(user.getId());
        response.setToken(user.getToken());
        return response;
    }

    /**
     * 用户登录
     */
    // 根据username和password进行登录
    public UserLoginResponse loginUser(UserLoginRequest request) {
        System.out.println(request);
        // 使用md5加密输入的密码
        String encryptedPassword = DigestUtils.md5DigestAsHex(request.getPassword().getBytes());
        User user = userMapper.selectByUsernameAndPassword(request.getUsername(), encryptedPassword);
        UserLoginResponse response = new UserLoginResponse();
        System.out.println(user);
        if (user != null) {
            // 登录成功，生成token
            response.setStatus_code(0);
            response.setStatus_msg("登录成功");
            response.setUser_id(user.getId());
            response.setToken(user.getToken());  // 使用用户表中的token
        } else {
            // 登录失败
            response.setStatus_code(1);
            response.setStatus_msg("登录失败，用户名或密码错误");
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
            response.setStatus_code(0);
            response.setStatus_msg("Success");
            response.setUser(user);
        } else {
            // 如果用户不存在，返回错误信息
            response.setStatus_code(1);
            response.setStatus_msg("User not found");
        }

        return response;
    }
    /**
     * 获取所有用户信息
     */
    public UserAllResponse getAllUsers(int id, String username, String token) {
        UserAllResponse response = new UserAllResponse();
        response.setStatus_code(0);
        response.setStatus_msg("Success");
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        if (id != 0) {
            queryWrapper.eq(User::getId, id);
        }
        if (username != null) {
            queryWrapper.eq(User::getUsername, username);
        }
        response.setUser(userMapper.selectList(queryWrapper).stream().map(User::ToUserMessage).toList());
        return response;
    }
    /**
     * 修改用户头像
     */
    // 根据用户id和新的头像地址修改用户头像
    public UserResponse updateAvatar(int id,String token, String avatar) {
        User user = userMapper.selectById(id);
        user.setAvatar(avatar);
        userMapper.updateById(user);

        UserResponse response = new UserResponse();
        response.setStatus_code(0);
        response.setStatus_msg("Success");
        response.setUser(user.ToUserMessage());
        return response;
    }

    /**
     * 更新用户信息
     */
    public UserUpdateResponse updateUser(UserUpdateRequest request) {
        User user = userMapper.selectById(request.getUser_id());
        if (user == null) {
            UserUpdateResponse response = new UserUpdateResponse();
            response.setStatus_code(1);
            response.setStatus_msg("User not found");
            return response;
        }
//        if (!request.getToken().equals(user.getToken())) {
//            UserUpdateResponse response = new UserUpdateResponse();
//            response.setStatus_code(2);
//            response.setStatus_msg("Token error");
//            return response;
//        }
        user.setUsername(request.getUsername());
        user.setLevel(request.getLevel());
        user.setPhoneNumber(request.getPhone_number());
        userMapper.updateById(user);
        UserUpdateResponse response = new UserUpdateResponse();
        response.setStatus_code(0);
        response.setStatus_msg("Success");
        return response;
    }
}
