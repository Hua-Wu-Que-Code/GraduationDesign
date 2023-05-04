package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 症状表
(Symptom)实体类
 *
 * @author huawuque
 * @since 2023-05-04 17:18:00
 */
public class Symptom implements Serializable {
    private static final long serialVersionUID = 611538813896778704L;
    /**
     * 症状表ID
     */
    private Integer id;
    /**
     * 症状名称
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

