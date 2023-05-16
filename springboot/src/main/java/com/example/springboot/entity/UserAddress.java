package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 用户地址表(UserAddress)实体类
 *
 * @author huawuque
 * @since 2023-05-16 16:49:51
 */
public class UserAddress implements Serializable {
    private static final long serialVersionUID = 496690770701505259L;
    /**
     * 用户地址表
     */
    private Integer id;
    /**
     * 地址ID
     */
    private Integer addressid;
    /**
     * 用户ID
     */
    private String userid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

}

