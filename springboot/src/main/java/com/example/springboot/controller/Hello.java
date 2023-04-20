package com.example.springboot.controller;

import com.example.springboot.entity.UserDisability;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
*   测试程序是否能够运行
* */

@RestController
@RequestMapping("/test")
public class Hello extends BaseController{

    @RequestMapping("/hello")
    @ResponseBody
    public UserDisability category() {
        String userId = "b3ed4f7b-0d55-4afa-85b7-e629d58d5eb2";
        List<UserDisability> userDisabilities = commonMapper.userInfoUserDisability(userId);
        return userDisabilities.get(0);
    }
}
