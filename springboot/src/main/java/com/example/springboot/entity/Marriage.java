package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 婚姻状况(Marriage)实体类
 *
 * @author huawuque
 * @since 2023-04-16 23:14:23
 */
public class Marriage implements Serializable {
    private static final long serialVersionUID = 569803062642669328L;
    /**
     * 婚姻状况
     */
    private Integer id;
    /**
     * 状况名称
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

