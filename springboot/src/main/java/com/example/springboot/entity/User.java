package com.example.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
     * 角色信息
     */
    private List<Integer> roles;
    /**
     * 权限
     */
    private Set<Permission> permissions;

}

