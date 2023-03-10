package com.example.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户信息表(User)实体类
 *
 * @author huawuque
 * @since 2023-03-10 11:04:49
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -88916332598912439L;
    /**
     * ID

     */
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 住址
     */
    private String address;
    /**
     * 角色：
        1.管理员
        2.医生
        3.供药商
        4.患者
     */
    private Integer role;
    /**
     * 权限
     */
    private List<Permission> permissions;

}

