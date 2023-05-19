package com.example.springboot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

/**
 * 医生表
(Doctor)实体类
 *
 * @author huawuque
 * @since 2023-04-27 15:14:40
 */
public class Doctor implements Serializable {
    private static final long serialVersionUID = 211179905838624296L;
    /**
     * 医生ID
     */
    private String id;
    /**
     * 医生姓名
     */
    private String name;
    /**
     * 医生年龄
     */
    private Integer age;
    /**
     * 联系方式
     */
    private String telephone;
    /**
     * 工作经验
     */
    private String workexper;

    private ArrayList<Patient> patients;

    private String education;

    private Date date;

    private User doctor;

    private Clinic clinic;

    private String ability;

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWorkexper() {
        return workexper;
    }

    public void setWorkexper(String workexper) {
        this.workexper = workexper;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

