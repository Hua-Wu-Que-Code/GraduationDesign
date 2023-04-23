package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
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
    @JsonIgnore
    private Integer sexId;
    private String sex;
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
    @JsonIgnore
    private Integer ethnicgroupID;
    private String ethnicGroup;
    /**
     * 血型
     */
    @JsonIgnore
    private Integer bloodtypeID;
    private String bloodType;
    /**
     * 文化程度
     */
    @JsonIgnore
    private Integer educationId;
    private String education;
    /**
     * 婚姻状况
     */
    @JsonIgnore
    private Integer marriageId;
    private String marriage;
    /**
     * 支付方式
     */
    @JsonIgnore
    private Integer pamentmethId;
    private String pamentmeth;
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

    /**
     * 工作情况
     */
    @JsonIgnore
    private Integer workId;
    private String work;

    /**
     *健康表中是否存有数据
     * 0表示无
     * 1表示有
     */
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

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



    public List<String> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<String> disabilities) {
        this.disabilities = disabilities;
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

    public Integer getEthnicgroupID() {
        return ethnicgroupID;
    }

    public void setEthnicgroupID(Integer ethnicgroupID) {
        this.ethnicgroupID = ethnicgroupID;
    }

    public Integer getBloodtypeID() {
        return bloodtypeID;
    }

    public void setBloodtypeID(Integer bloodtypeID) {
        this.bloodtypeID = bloodtypeID;
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

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getSexId() {
        return sexId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEthnicGroup() {
        return ethnicGroup;
    }

    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = ethnicGroup;
    }

    public String getEducation() {
        return education;
    }

    public Integer getMarriageId() {
        return marriageId;
    }

    public void setMarriageId(Integer marriageId) {
        this.marriageId = marriageId;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public Integer getPamentmethId() {
        return pamentmethId;
    }

    public void setPamentmethId(Integer pamentmethId) {
        this.pamentmethId = pamentmethId;
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
}

