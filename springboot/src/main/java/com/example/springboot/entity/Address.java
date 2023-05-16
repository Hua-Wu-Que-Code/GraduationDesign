package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 地址表(Address)实体类
 *
 * @author huawuque
 * @since 2023-05-16 16:49:51
 */
public class Address implements Serializable {
    private static final long serialVersionUID = 469639492340459811L;
    /**
     * 地址表ID
     */
    private Integer id;
    /**
     * 省份名称
     */
    private String province;
    /**
     * 城市名称
     */
    private String city;
    /**
     * 县
     */
    private String county;
    /**
     * 详细
     */
    private String detail;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}

