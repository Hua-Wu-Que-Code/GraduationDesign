package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 饮食习惯表(Eathab)实体类
 *
 * @author huawuque
 * @since 2023-05-04 17:18:00
 */
public class Eathab implements Serializable {
    private static final long serialVersionUID = -64520981895859632L;
    /**
     * 饮食习惯表ID
     */
    private Integer id;
    /**
     * 饮食习惯名称
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

