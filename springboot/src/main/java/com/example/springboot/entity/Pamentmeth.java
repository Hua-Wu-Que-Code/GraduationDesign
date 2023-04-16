package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 支付方式表(Pamentmeth)实体类
 *
 * @author huawuque
 * @since 2023-04-16 23:15:11
 */
public class Pamentmeth implements Serializable {
    private static final long serialVersionUID = 136519333111514215L;
    /**
     * 支付方式ID
     */
    private Integer id;
    /**
     * 支付方式名称
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

