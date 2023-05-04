package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 职业暴露史表(Expose)实体类
 *
 * @author huawuque
 * @since 2023-05-04 17:18:00
 */
public class Expose implements Serializable {
    private static final long serialVersionUID = -50465730584361082L;
    /**
     * 职业暴露史ID
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

