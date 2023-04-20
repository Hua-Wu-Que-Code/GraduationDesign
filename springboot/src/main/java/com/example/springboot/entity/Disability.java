package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 残疾表(Disability)实体类
 *
 * @author huawuque
 * @since 2023-04-20 22:01:20
 */
public class Disability implements Serializable {
    private static final long serialVersionUID = -44463162346684384L;
    /**
     * 残疾表ID
     */
    private Integer id;
    /**
     * 残疾表名称
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

