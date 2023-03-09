package com.example.springboot.config;

import com.example.springboot.interceptor.AuthInterceptor;
import com.example.springboot.jwt.JwtUtil;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport
{
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UserService userService;
    @Override
    public void addInterceptors(InterceptorRegistry reg) {
        reg.addInterceptor(new AuthInterceptor(jwtUtil,userService))
                //拦截的url
                .addPathPatterns("/**")
                //排除的url
                .excludePathPatterns(excludePattern());
    }

    public List<String> excludePattern(){
        List<String> ret = new ArrayList<String>();
        ret.add("/signIn");
        ret.add("/signUp");
        ret.add("/hello");
        return ret;
    }
}
