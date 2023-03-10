package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * 动态路由，登陆许可(Permission)实体类
 *
 * @author huawuque
 * @since 2023-03-10 16:29:35
 */
public class Permission implements Serializable {
    private static final long serialVersionUID = -49906253696841845L;
    /**
     * 路由id
	
     */
    @JsonIgnore
    private Integer id;
    /**
     * 路由名称

     */
    private String name;
    /**
     * 路由路径
     */
    private String path;
    /**
     * 角色是否可以访问

     */
    @JsonIgnore
    private Integer role;
    /**
     * 路由名称
     */
    private String comment;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

