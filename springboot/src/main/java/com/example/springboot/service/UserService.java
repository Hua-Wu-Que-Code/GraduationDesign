package com.example.springboot.service;

import com.example.springboot.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description user 的 service 层 构建
 * @date 2023/3/9 21:21:52
 */
@Service
public class UserService extends BaseService{

    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    public User findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }
}
