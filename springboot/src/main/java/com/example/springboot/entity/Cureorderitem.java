package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 诊所销售订单小项目(Cureorderitem)实体类
 *
 * @author huawuque
 * @since 2023-05-19 23:01:18
 */
public class Cureorderitem implements Serializable {
    private static final long serialVersionUID = -23576983987674051L;
    /**
     * 诊所销售项目Id
     */
    private Integer id;
    /**
     * 药品Id
     */
    private String drugid;
    /**
     * 药品数目
     */
    private Integer num;
    /**
     * 诊所销售订单Id
     */
    private String cureorderid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {
        this.drugid = drugid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCureorderid() {
        return cureorderid;
    }

    public void setCureorderid(String cureorderid) {
        this.cureorderid = cureorderid;
    }

}

