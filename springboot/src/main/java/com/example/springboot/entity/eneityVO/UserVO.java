package com.example.springboot.entity.eneityVO;

import com.example.springboot.entity.Permission;
import com.example.springboot.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description user 的抽离类
 * @date 2023/3/10 11:07:53
 */
public class UserVO {
    /**
     * token
     */
    private String token;
    /**
     * 用户名
     */
    private String username;
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
     * 权限
     */
    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public UserVO(String token, User user) {
        this.token = token;
        this.username = user.getUsername();
        this.age = user.getAge();
        this.sex = user.getSex();
        this.address = user.getAddress();
        this.role = user.getRole();
        this.permissions = user.getPermissions();
    }

    /**
     * 角色：
     1.管理员
     2.医生
     3.供药商
     4.患者
     */

    private Integer role;

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    public Integer getRole() {
        return role;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
