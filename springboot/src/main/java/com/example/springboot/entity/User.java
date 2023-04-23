package com.example.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户信息表(User)实体类
 *
 * @author huawuque
 * @since 2023-04-13 00:11:57
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -22228781161608810L;
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
     * 角色：
        1.管理员
        2.医生
        3.供药商
        4.患者
     */
    private Integer roleid;

    private List<String> roles;

    /**
     * 账号状态
     */
    private boolean status;

    /**
     * 头像
     */
    private String avatar;


}

