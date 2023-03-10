package com.example.springboot.mapper;

import com.example.springboot.entity.Permission;
import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description user 的Mapepr类
 * @date 2023/3/9 21:25:15
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(property = "permissions", column = "role", javaType = List.class,
                    many = @Many(select = "findPermissions"))
    })
    User findUserById(String id);

    @Select("select * from permission where role = #{role}")
    List<Permission> findPermissions(int role);

    @Select("select * from user where username = #{username}")
    User findUserByUserName(String username);

}
