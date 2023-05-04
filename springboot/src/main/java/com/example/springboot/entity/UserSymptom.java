package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 用户症状对应表(UserSymptom)实体类
 *
 * @author huawuque
 * @since 2023-05-04 17:18:00
 */
public class UserSymptom implements Serializable {
    private static final long serialVersionUID = -83058506710142724L;
    /**
     * 用户体检症状表ID
     */
    private Integer id;
    /**
     * 症状表ID
     */
    private Integer symptomid;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 体检表ID
     */
    private Integer examid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSymptomid() {
        return symptomid;
    }

    public void setSymptomid(Integer symptomid) {
        this.symptomid = symptomid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

}

