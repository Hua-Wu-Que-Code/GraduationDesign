package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 咽部情况表(Pharynx)实体类
 *
 * @author huawuque
 * @since 2023-05-04 17:18:00
 */
public class Pharynx implements Serializable {
    private static final long serialVersionUID = 912716036687812426L;
    /**
     * 咽部ID
     */
    private Integer id;
    /**
     * 情况名称
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

