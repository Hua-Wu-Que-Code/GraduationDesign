package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 文化程度表(Education)实体类
 *
 * @author huawuque
 * @since 2023-04-16 23:14:23
 */
public class Education implements Serializable {
    private static final long serialVersionUID = -11940600041090662L;
    /**
     * 文化程度表ID
     */
    private Integer id;
    /**
     * 名称
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

