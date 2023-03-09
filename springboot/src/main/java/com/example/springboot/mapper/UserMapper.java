package com.example.springboot.mapper;

import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description user 的Mapepr类
 * @date 2023/3/9 21:25:15
 */
@Mapper
public interface UserMapper {
    User findUserById(int id);
}
