package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 民族表(Ethnicgroup)实体类
 *
 * @author huawuque
 * @since 2023-04-16 23:14:23
 */
public class Ethnicgroup implements Serializable {
    private static final long serialVersionUID = 800975944464504742L;
    /**
     * 民族id
     */
    private Integer id;
    /**
     * 名族名称
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

