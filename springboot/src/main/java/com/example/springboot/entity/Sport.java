package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 运动表(Sport)实体类
 *
 * @author huawuque
 * @since 2023-05-04 17:18:00
 */
public class Sport implements Serializable {
    private static final long serialVersionUID = 715018263821646800L;
    /**
     * 运动表ID
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

