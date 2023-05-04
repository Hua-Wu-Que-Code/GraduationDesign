package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 锻炼频率表(Exefre)实体类
 *
 * @author huawuque
 * @since 2023-05-04 17:18:00
 */
public class Exefre implements Serializable {
    private static final long serialVersionUID = -42587860060792087L;
    /**
     * 锻炼频率表ID
     */
    private Integer id;
    /**
     * 锻炼频率名称
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

