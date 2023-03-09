package com.example.springboot.service;

import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description 基础的Service层
 * @date 2023/3/9 21:24:25
 */
public class BaseService {
    @Autowired
    UserMapper userMapper;
}
