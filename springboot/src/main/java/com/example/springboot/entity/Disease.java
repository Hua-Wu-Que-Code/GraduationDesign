package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 疾病表(Disease)实体类
 *
 * @author huawuque
 * @since 2023-04-20 17:04:40
 */
public class Disease implements Serializable {
    private static final long serialVersionUID = 624575101657125067L;
    /**
     * 疾病表
     */
    private Integer id;
    /**
     * 疾病名称
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

