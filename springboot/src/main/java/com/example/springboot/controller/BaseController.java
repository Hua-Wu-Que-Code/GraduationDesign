package com.example.springboot.controller;

import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description
 * @date 2023/3/9 22:41:22
 */
public class BaseController {

    @Autowired
    UserService userService;

    @Autowired
    HttpServletRequest request;
}
