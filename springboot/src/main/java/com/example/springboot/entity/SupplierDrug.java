package com.example.springboot.entity;

import java.io.Serializable;

/**
 * (SupplierDrug)实体类
 *
 * @author huawuque
 * @since 2023-05-18 03:23:17
 */
public class SupplierDrug implements Serializable {
    private static final long serialVersionUID = -81986309731398843L;
    /**
     * 供货商Id
     */
    private String supplierid;

    private Supplier supplier;
    /**
     * 药品ID
     */
    private String drugid;
    /**
     * 药品数量
     */
    private Integer num;
    /**
     * 药品价格
     */
    private Object price;
    /**
     * 表ID
     */
    private Integer id;

    private Drug drug;

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}

