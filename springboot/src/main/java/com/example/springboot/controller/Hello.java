package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/*
*   测试程序是否能够运行
* */

@RestController
@RequestMapping("/test")
public class Hello {

    @RequestMapping("/hello")
    @ResponseBody
    public String category() {
        return "hello";
    }
}
