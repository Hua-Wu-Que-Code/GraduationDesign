package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 遗传病表(HeritageDisease)实体类
 *
 * @author huawuque
 * @since 2023-04-21 10:48:13
 */
public class HeritageDisease implements Serializable {
    private static final long serialVersionUID = -93042809639590667L;
    /**
     * 遗传病表ID
     */
    private Integer id;
    /**
     * 遗传病名称
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

