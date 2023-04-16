package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 药物过敏史表格(Allergyhistory)实体类
 *
 * @author huawuque
 * @since 2023-04-16 23:14:21
 */
public class Allergyhistory implements Serializable {
    private static final long serialVersionUID = 356632938633190618L;
    /**
     * 药物过敏历史ID
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

