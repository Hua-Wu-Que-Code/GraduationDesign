package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 用户遗传病表(UserHeritage)实体类
 *
 * @author huawuque
 * @since 2023-04-21 10:48:13
 */
public class UserHeritage implements Serializable {
    private static final long serialVersionUID = 204236601389952709L;
    /**
     * 用户遗传病ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 遗传病ID
     */
    private Integer heritageid;


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

    public Integer getHeritageid() {
        return heritageid;
    }

    public void setHeritageid(Integer heritageid) {
        this.heritageid = heritageid;
    }

}

