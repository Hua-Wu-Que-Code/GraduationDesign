package com.example.springboot.mapper;

import com.example.springboot.entity.Permission;
import com.example.springboot.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description 用户角色mapper类
 * @date 2023/3/14 15:37:28
 */
@Mapper
public interface UserRoleMapper {

    @Select("select * from user_role where userId = #{userId}")
    List<UserRole> findRoleId(String userId);
}
