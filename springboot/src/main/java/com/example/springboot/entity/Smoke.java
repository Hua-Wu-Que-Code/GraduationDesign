package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 吸烟情况表(Smoke)实体类
 *
 * @author huawuque
 * @since 2023-05-04 17:18:00
 */
public class Smoke implements Serializable {
    private static final long serialVersionUID = 599777645297715827L;
    /**
     * 吸烟情况表ID
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

