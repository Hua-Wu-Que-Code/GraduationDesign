package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 工作表(Work)实体类
 *
 * @author huawuque
 * @since 2023-04-17 19:25:07
 */
public class Work implements Serializable {
    private static final long serialVersionUID = -44247654946174851L;
    /**
     * 工作表id
     */
    private Integer id;
    /**
     * 工作名称
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

