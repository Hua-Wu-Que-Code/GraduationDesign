package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 性别表(Sex)实体类
 *
 * @author huawuque
 * @since 2023-04-17 19:24:48
 */
public class Sex implements Serializable {
    private static final long serialVersionUID = 630801072051952877L;
    /**
     * 性别表id
     */
    private Integer id;
    /**
     * 性别名称
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

