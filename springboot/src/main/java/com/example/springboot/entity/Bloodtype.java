package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 血型表(Bloodtype)实体类
 *
 * @author huawuque
 * @since 2023-04-16 23:14:23
 */
public class Bloodtype implements Serializable {
    private static final long serialVersionUID = -71383422927180186L;
    /**
     * 血型表ID
     */
    private Integer id;
    /**
     * 血型名称
     */
    private String name;


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

}

