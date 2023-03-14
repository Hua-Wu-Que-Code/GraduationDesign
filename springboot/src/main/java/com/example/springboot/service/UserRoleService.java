package com.example.springboot.service;

import com.example.springboot.entity.UserRole;
import com.example.springboot.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description
 * @date 2023/3/14 15:41:07
 */
@Service
public class UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;
    public  List<UserRole> findRoleId(String userId) {
        return userRoleMapper.findRoleId(userId);
    }

}
