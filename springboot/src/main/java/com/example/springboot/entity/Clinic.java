package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;

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
     * 联系方式
     */
    private String telephone;

    private Doctor doctor;
    /**
     * 营业时间
     */
    private int startTime;
    private int closeTime;

    /**
     * 营业状态
     */
    private String status;

    private String avatar;

    private String desc;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private ArrayList<Schedule> time;


    public ArrayList<Schedule> getTime() {
        return time;
    }

    public void setTime(ArrayList<Schedule> time) {
        this.time = time;
    }

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

