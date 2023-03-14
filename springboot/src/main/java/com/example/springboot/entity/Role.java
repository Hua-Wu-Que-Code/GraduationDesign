package com.example.springboot.entity;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author huawuque
 * @since 2023-03-14 15:20:18
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -23098833595769440L;
    /**
     * 权限id
     */
    private Integer id;
    /**
     * 权限名
     */
    private String name;
    /**
     * 权限详细
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}

