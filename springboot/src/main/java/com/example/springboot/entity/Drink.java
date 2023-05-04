package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 饮酒情况表(Drink)实体类
 *
 * @author huawuque
 * @since 2023-05-04 17:18:00
 */
public class Drink implements Serializable {
    private static final long serialVersionUID = 948892610667032976L;
    /**
     * 饮酒情况表ID
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

