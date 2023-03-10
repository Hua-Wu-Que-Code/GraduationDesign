package com.example.springboot.interceptor;

import com.example.springboot.entity.User;
import com.example.springboot.jwt.JwtUtil;
import com.example.springboot.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor
{

    private JwtUtil jwtUtil;
    private UserService userService;

    public AuthInterceptor(JwtUtil jwtUtil, UserService userService){
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception{
        String token = req.getHeader("Authorization");
        if(token == null)
        {
            throw new Exception("请登录！");
        }
        Claims claim = jwtUtil.getClaimByToken(token);
        if(claim == null)
        {
            throw new JwtException("token异常！");
        }
        if(jwtUtil.isTokenExpired(claim))
        {
            throw new JwtException("token已过期！");
        }
        String initId = claim.getSubject();
        User user = userService.findUserById(initId);
        if(user == null)
        {
            throw new Exception("用户验证失败");
        }
        req.setAttribute("id",user.getId());
        req.setAttribute("UserToken", token);
        return true;
    }
}
