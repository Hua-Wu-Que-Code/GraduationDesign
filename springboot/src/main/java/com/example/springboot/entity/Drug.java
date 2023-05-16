package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 药品详细表(Drug)实体类
 *
 * @author huawuque
 * @since 2023-05-17 00:54:14
 */
public class Drug implements Serializable {
    private static final long serialVersionUID = 367597392322817670L;
    /**
     * 药品表ID
     */
    private String drugid;
    /**
     * 药品名称
     */
    private String drugname;
    /**
     * 生产厂家
     */
    private String nanu;
    /**
     * 批准文号
     */
    private String pawh;
    /**
     * 药品分类
     */
    private String classifyid;


    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {
        this.drugid = drugid;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getNanu() {
        return nanu;
    }

    public void setNanu(String nanu) {
        this.nanu = nanu;
    }

    public String getPawh() {
        return pawh;
    }

    public void setPawh(String pawh) {
        this.pawh = pawh;
    }

    public String getClassifyid() {
        return classifyid;
    }

    public void setClassifyid(String classifyid) {
        this.classifyid = classifyid;
    }

}

