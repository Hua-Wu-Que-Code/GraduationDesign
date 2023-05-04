package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 齿序表(Tooth)实体类
 *
 * @author huawuque
 * @since 2023-05-04 17:18:00
 */
public class Tooth implements Serializable {
    private static final long serialVersionUID = 171235946077608722L;
    /**
     * 齿序ID
     */
    private Integer id;
    /**
     * 齿序名称
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

