package com.example.springboot.entity;

import java.io.Serializable;

/**
 * (UserAllergy)实体类
 *
 * @author huawuque
 * @since 2023-04-21 10:18:59
 */
public class UserAllergy implements Serializable {
    private static final long serialVersionUID = -10415256821898689L;
    /**
     * 用户过敏情况表ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 过敏ID
     */
    private Integer allergyid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getAllergyid() {
        return allergyid;
    }

    public void setAllergyid(Integer allergyid) {
        this.allergyid = allergyid;
    }

}

