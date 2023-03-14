package com.example.springboot.entity;

import lombok.Data;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description 权限路由
 * @date 2023/3/14 15:21:01
 */
@Data
public class RolePermission {
    private Integer roleId;
    private Integer permissionId;
}
