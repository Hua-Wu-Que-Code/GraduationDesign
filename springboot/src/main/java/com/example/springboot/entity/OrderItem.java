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
    private String id;
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

    private Drug drug;

    private Doctor doctor;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    private Supplier supplier;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    /**
     * 订单状态 0:待发货,1:未支付,2待收货,3:申请取消,4:订单取消,5:订单完成,6:商家取消;7:申请退货,8:同意退货,9:订单超时,10:商家拒绝
     */
    private Integer status;

    private String statusStr;

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}

