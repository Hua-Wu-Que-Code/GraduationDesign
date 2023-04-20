package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 用户残疾情况表(UserDisability)实体类
 *
 * @author huawuque
 * @since 2023-04-20 23:14:56
 */
public class UserDisability implements Serializable {
    private static final long serialVersionUID = -69279789188960835L;
    /**
     * 用户残疾表ID
     */
    private Integer id;
    /**
     * 残疾表ID
     */
    private Integer disabilityid;
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

    public Integer getDisabilityid() {
        return disabilityid;
    }

    public void setDisabilityid(Integer disabilityid) {
        this.disabilityid = disabilityid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

}

