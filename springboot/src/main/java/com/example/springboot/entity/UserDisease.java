package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 患者疾病表(UserDisease)实体类
 *
 * @author huawuque
 * @since 2023-04-20 17:05:02
 */
public class UserDisease implements Serializable {
    private static final long serialVersionUID = -66553557392348523L;
    /**
     * 患者疾病关系表ID
     */
    private Integer id;
    /**
     * 患者ID
     */
    private String userid;
    /**
     * 疾病ID
     */
    private Integer diseaseid;


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

    public Integer getDiseaseid() {
        return diseaseid;
    }

    public void setDiseaseid(Integer diseaseid) {
        this.diseaseid = diseaseid;
    }

}

