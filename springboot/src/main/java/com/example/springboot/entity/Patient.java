package com.example.springboot.entity;

import com.example.springboot.entity.eneityVO.UserInfo;

import java.io.Serializable;

/**
 * (Patient)实体类
 *
 * @author huawuque
 * @since 2023-05-19 02:38:13
 */
public class Patient implements Serializable {
    private static final long serialVersionUID = -42251777971895649L;
    /**
     * 居民表Id
     */
    private String id;
    /**
     * 诊所医生表ID
     */
    private String doctorid;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 性别
     */
    private Integer sex;
    private String sexStr;
    /**
     * 姓名
     */
    private String name;
    /**
     * 民族
     */
    private Integer groupid;
    private String groupStr;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 文化程度
     */
    private Integer education;
    private String educationStr;

    private UserInfo userInfo;


    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
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

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getSex() {
        return sex;
    }

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public String getGroupStr() {
        return groupStr;
    }

    public void setGroupStr(String groupStr) {
        this.groupStr = groupStr;
    }

    public String getEducationStr() {
        return educationStr;
    }

    public void setEducationStr(String educationStr) {
        this.educationStr = educationStr;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

}

