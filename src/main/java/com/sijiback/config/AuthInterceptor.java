package com.sijiback.config;

import com.sijiback.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import java.lang.reflect.Method;

@Component
public class AuthInterceptor implements HandlerInterceptor {
//    @Autowired
//    private UserService userService;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception{
//        // 获取token
//        String token = request.getHeader("token");
//        //如果不是映射到Controller直接放行
//        //如果没有这句类型判断，当处理跨域请求时，类型转换会报错
//        if(!(object instanceof HandlerMethod handlerMethod)){
//            return true;
//        }
//        // 检查是否需要验证token
//        Method method = handlerMethod.getMethod();
//        //是否存在VerifyAdminToken注解，这个注解后文会说明
//        if(method.isAnnotationPresent(VerifyAdminToken.class)){
//            // 获取注解，验证token是否符合注解要求
//            String str = checkToken(method.getAnnotation(VerifyAdminToken.class),token);
//            if(!StringUtils.isEmpty(str)) throw new RuntimeException(str);
//            return true;
//        }
//        return true;
//    }
//
//    // 检验token
//    public String checkToken(VerifyAdminToken loginToken,String token){
//        if(loginToken.required()){
//            if(token == null)return "该请求没有token，请先获取token";
//            if(userService.GetUserByToken(token)==null)return "未找到持有该token的用户";
//            if(userService.GetUserByToken(token).getLevel()>=loginToken.level()){// token用户等级大于有效，判断是否要刷新令牌
//                return null;
//            }else{
//                return "无效令牌";
//            }
//        }
//        return null;
//    }
}

