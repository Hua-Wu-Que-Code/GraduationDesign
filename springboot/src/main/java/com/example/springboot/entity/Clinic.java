package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * 诊所信息表(Clinc)实体类
 *
 * @author huawuque
 * @since 2023-04-27 15:14:40
 */
public class Clinic implements Serializable {
    private static final long serialVersionUID = 226803837641724564L;
    /**
     * 诊所ID
     */
    private String id;
    /**
     * 诊所名称
     */
    private String name;
    /**
     * 诊所地点
     */
    private String address;
    /**
     * 联系方式
     */
    private String telephone;
    /**
     * 医生ID
     */
    @JsonIgnore
    private String dortorid;
    private Doctor doctor;
    /**
     * 营业时间
     */
    private String businesshour;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDortorid() {
        return dortorid;
    }

    public void setDortorid(String dortorid) {
        this.dortorid = dortorid;
    }

    public String getBusinesshour() {
        return businesshour;
    }

    public void setBusinesshour(String businesshour) {
        this.businesshour = businesshour;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

