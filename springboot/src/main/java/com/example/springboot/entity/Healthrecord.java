package com.example.springboot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户健康档案表(Healthrecord)实体类
 *
 * @author huawuque
 * @since 2023-04-16 23:14:23
 */
public class Healthrecord implements Serializable {
    private static final long serialVersionUID = -69285681396590704L;
    /**
     * 健康档案表id
     */
    private Integer id;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 性别；0为男，1为女

     */
    private Integer sex;
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
    private String telephonenumer;
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
    private Integer education;
    /**
     * 婚姻状况
     */
    private Integer marriage;
    /**
     * 支付方式
     */
    private Integer pamentmeth;
    /**
     * 过敏历史
     */
    private Integer allergyhistory;
    /**
     * 疾病历史
     */
    private Integer disease;
    /**
     * 外伤记录
     */
    private Integer surgery;
    /**
     * 输血历史
     */
    private Integer bloodtrans;
    /**
     * 遗传病历史
     */
    private Integer heredityhistory;
    /**
     * 残疾情况

     */
    private Integer disability;


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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public String getTelephonenumer() {
        return telephonenumer;
    }

    public void setTelephonenumer(String telephonenumer) {
        this.telephonenumer = telephonenumer;
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

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    public Integer getPamentmeth() {
        return pamentmeth;
    }

    public void setPamentmeth(Integer pamentmeth) {
        this.pamentmeth = pamentmeth;
    }

    public Integer getAllergyhistory() {
        return allergyhistory;
    }

    public void setAllergyhistory(Integer allergyhistory) {
        this.allergyhistory = allergyhistory;
    }

    public Integer getDisease() {
        return disease;
    }

    public void setDisease(Integer disease) {
        this.disease = disease;
    }

    public Integer getSurgery() {
        return surgery;
    }

    public void setSurgery(Integer surgery) {
        this.surgery = surgery;
    }

    public Integer getBloodtrans() {
        return bloodtrans;
    }

    public void setBloodtrans(Integer bloodtrans) {
        this.bloodtrans = bloodtrans;
    }

    public Integer getHeredityhistory() {
        return heredityhistory;
    }

    public void setHeredityhistory(Integer heredityhistory) {
        this.heredityhistory = heredityhistory;
    }

    public Integer getDisability() {
        return disability;
    }

    public void setDisability(Integer disability) {
        this.disability = disability;
    }

}

