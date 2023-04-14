package com.example.springboot.mapper;

import com.example.springboot.entity.Role;
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
public interface RoleMapper {

    @Select("select name from role where id = #{id}")
    List<String> findRoleName(Integer id);

    @Select("select introduction from role where id = #{id}")
    List<String> findRoleIntroduction(Integer id);
}
