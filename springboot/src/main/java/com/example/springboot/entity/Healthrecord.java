package com.example.springboot.entity;

import org.w3c.dom.ls.LSException;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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
     * 姓名
     */
    private String name;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 性别；0为男，1为女，3为不方便透露
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
    private List<String> allergyhistory;
    /**
     * 疾病历史
     */
    private List<String> diseases;
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
    private List<String> heredityhistory;
    /**
     * 残疾情况
     */
    private List<String> disabilities;

    /**
     * 工作情况
     */
    private Integer workId;


    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
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

    public Integer getSex() {
        return sex;
    }

    public List<String> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<String> disabilities) {
        this.disabilities = disabilities;
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

    public String getTelephone() {
        return telephone;
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

    public List<String> getHeredityhistory() {
        return heredityhistory;
    }

    public void setHeredityhistory(List<String> heredityhistory) {
        this.heredityhistory = heredityhistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

