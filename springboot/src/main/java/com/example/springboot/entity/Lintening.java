package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 听力表(Lintening)实体类
 *
 * @author huawuque
 * @since 2023-05-04 17:18:00
 */
public class Lintening implements Serializable {
    private static final long serialVersionUID = 162984006623163938L;
    /**
     * 听力表ID
     */
    private Integer id;
    /**
     * 听力名称
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

