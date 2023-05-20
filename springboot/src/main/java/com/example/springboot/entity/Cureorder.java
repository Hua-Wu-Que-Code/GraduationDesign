package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

/**
 * (Cureorder)实体类
 *
 * @author huawuque
 * @since 2023-05-19 23:01:18
 */
public class Cureorder implements Serializable {
    private static final long serialVersionUID = -33712558748032246L;
    /**
     * 诊所销售订单Id
     */
    private String id;
    /**
     * 医生id
     */
    private String doctorid;
    /**
     * 用户id
     */
    private String userid;
    /**
     * 患者名称
     */
    private String name;
    /**
     * 病情描述
     */
    private String des;
    /**
     * 订单时间
     */
    private Date date;

    private ArrayList<Cureorderitem> cureorderitems;

    public ArrayList<Cureorderitem> getCureorderitems() {
        return cureorderitems;
    }

    public void setCureorderitems(ArrayList<Cureorderitem> cureorderitems) {
        this.cureorderitems = cureorderitems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

