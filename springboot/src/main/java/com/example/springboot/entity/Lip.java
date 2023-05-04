package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 嘴唇情况表(Lip)实体类
 *
 * @author huawuque
 * @since 2023-05-04 17:18:00
 */
public class Lip implements Serializable {
    private static final long serialVersionUID = 756398161784686118L;
    /**
     * 嘴唇情况ID
     */
    private Integer id;
    /**
     * 嘴唇情况名称
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

