package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 用户饮食情况表(UserEathab)实体类
 *
 * @author huawuque
 * @since 2023-05-04 17:18:00
 */
public class UserEathab implements Serializable {
    private static final long serialVersionUID = 662921421984761830L;
    /**
     * 用户饮食习惯表ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 饮食习惯ID
     */
    private Integer eathabid;
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getEathabid() {
        return eathabid;
    }

    public void setEathabid(Integer eathabid) {
        this.eathabid = eathabid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

}

