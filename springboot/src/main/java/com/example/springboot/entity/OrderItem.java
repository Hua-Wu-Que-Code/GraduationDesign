package com.example.springboot.entity;

import java.io.Serializable;

/**
 * (OrderItem)实体类
 *
 * @author huawuque
 * @since 2023-05-18 17:25:36
 */
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 856325482817775299L;
    /**
     * 订单项Id
     */
    private Integer id;
    /**
     * 订单Id
     */
    private String orderid;
    /**
     * 购买数量
     */
    private Integer buynum;
    /**
     * 订单项费用
     */
    private Double itemmony;
    /**
     * 供货商Id
     */
    private String supplierid;
    /**
     * 药品Id
     */
    private String drugid;
    /**
     * 药品价格
     */
    private Double price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Integer getBuynum() {
        return buynum;
    }

    public void setBuynum(Integer buynum) {
        this.buynum = buynum;
    }

    public Double getItemmony() {
        return itemmony;
    }

    public void setItemmony(Double itemmony) {
        this.itemmony = itemmony;
    }

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }

    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {
        this.drugid = drugid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}

