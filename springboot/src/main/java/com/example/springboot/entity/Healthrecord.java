package com.example.springboot.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 用户健康档案表(Healthrecord)实体类
 *
 * @author huawuque
 * @since 2023-05-19 21:35:06
 */
public class Healthrecord implements Serializable {
    private static final long serialVersionUID = -69607476924870660L;
    /**
     * 健康档案表id
     */
    private Integer id;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 性别
     */
    private Integer sexid;
    /**
     * 出生日期

     */
    private Date date;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 工作单位
     */
    private String workplace;
    /**
     * 电话号码
     */
    private String telephone;
    /**
     * 联系人姓名
     */
    private String contactname;
    /**
     * 联系人电话
     */
    private String contactphone;
    /**
     * 常住类型：
1:户籍
2:非户籍
     */
    private Integer typeofpermanent;
    /**
     * 民族ID
     */
    private Integer ethnicgroupid;
    /**
     * 血型
     */
    private Integer bloodtypeid;
    /**
     * 文化程度
     */
    private Integer educationid;
    /**
     * 婚姻状况
     */
    private Integer marriageid;
    /**
     * 支付方式
     */
    private Integer pamentmethid;
    /**
     * 姓名
     */
    private String name;
    /**
     * 职业
     */
    private Integer workid;
    /**
     * 过敏历史
     */
    private List<String> allergyhistory;
    /**
     * 疾病历史
     */
    private List<String> diseases;

    /**
     * 遗传病历史
     */
    private List<String> heredityhistory;
    /**
     * 残疾情况
     */
    private List<String> disabilities;
    private String ethnicGroup;
    private String bloodType;
    private String Sex;
    private String education;
    private String marriage;
    private String pamentmeth;
    private String work;

    public List<String> getAllergyhistory() {
        return allergyhistory;
    }

    public void setAllergyhistory(List<String> allergyhistory) {
        this.allergyhistory = allergyhistory;
    }

    public List<String> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<String> diseases) {
        this.diseases = diseases;
    }

    public List<String> getHeredityhistory() {
        return heredityhistory;
    }

    public void setHeredityhistory(List<String> heredityhistory) {
        this.heredityhistory = heredityhistory;
    }

    public List<String> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<String> disabilities) {
        this.disabilities = disabilities;
    }

    public String getEthnicGroup() {
        return ethnicGroup;
    }

    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = ethnicGroup;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getPamentmeth() {
        return pamentmeth;
    }

    public void setPamentmeth(String pamentmeth) {
        this.pamentmeth = pamentmeth;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getSexid() {
        return sexid;
    }

    public void setSexid(Integer sexid) {
        this.sexid = sexid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }

    public Integer getTypeofpermanent() {
        return typeofpermanent;
    }

    public void setTypeofpermanent(Integer typeofpermanent) {
        this.typeofpermanent = typeofpermanent;
    }

    public Integer getEthnicgroupid() {
        return ethnicgroupid;
    }

    public void setEthnicgroupid(Integer ethnicgroupid) {
        this.ethnicgroupid = ethnicgroupid;
    }

    public Integer getBloodtypeid() {
        return bloodtypeid;
    }

    public void setBloodtypeid(Integer bloodtypeid) {
        this.bloodtypeid = bloodtypeid;
    }

    public Integer getEducationid() {
        return educationid;
    }

    public void setEducationid(Integer educationid) {
        this.educationid = educationid;
    }

    public Integer getMarriageid() {
        return marriageid;
    }

    public void setMarriageid(Integer marriageid) {
        this.marriageid = marriageid;
    }

    public Integer getPamentmethid() {
        return pamentmethid;
    }

    public void setPamentmethid(Integer pamentmethid) {
        this.pamentmethid = pamentmethid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

}

