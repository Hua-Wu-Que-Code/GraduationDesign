package com.example.springboot.mapper;

import com.example.springboot.entity.Permission;
import com.example.springboot.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description permission mapper类
 * @date 2023/3/14 15:49:05
 */
@Mapper
public interface PermissionMapper {

    @Select("select * from role_permission where roleId = #{roleId}")
    List<RolePermission> getRolePermissionByRoleId(Integer roleId);

    @Select("select * from permission where id = #{permissionId}")
    Permission selectById(Integer permissionId);
}
