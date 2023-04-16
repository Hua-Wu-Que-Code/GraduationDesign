package com.example.springboot.service;

import com.example.springboot.entity.ListQuery;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description user 的 service 层 构建
 * @date 2023/3/9 21:21:52
 */
@Service
public class UserService{

    @Autowired
    UserMapper userMapper;

    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    public User findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }

    public List<User> findUsersAdmin(ListQuery query) {
        int page = query.getPage();
        int limit = query.getLimit();
        return userMapper.findUsersAdmin(page,limit);
    }

    public int forEachDelete(String id) {
        return userMapper.forEachDelete(id);
    }


}
