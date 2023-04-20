package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 用户残疾情况表(UserDisability)实体类
 *
 * @author huawuque
 * @since 2023-04-20 22:33:03
 */
public class UserDisability implements Serializable {
    private static final long serialVersionUID = 838465663237496432L;
    /**
     * 用户残疾表ID
     */
    private Integer id;
    /**
     * 残疾表ID
     */
    private Integer disabilityId;
    /**
     * 用户ID
     */
    private String userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDisabilityId() {
        return disabilityId;
    }

    public void setDisabilityId(Integer disabilityId) {
        this.disabilityId = disabilityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}

