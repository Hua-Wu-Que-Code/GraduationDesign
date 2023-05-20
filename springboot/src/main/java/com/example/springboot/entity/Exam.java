package com.example.springboot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 体检详情表(Exam)实体类
 *
 * @author huawuque
 * @since 2023-05-19 18:43:35
 */
public class Exam implements Serializable {
    private static final long serialVersionUID = 782673951025571777L;
    /**
     * 用户体检表ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户ID
     */
    private String userid;
    /**
     * 体检时间
     */
    private Date date;
    /**
     * 体检医生
     */
    private String doctorname;
    /**
     * 体温
     */
    private String temperature;
    /**
     * 脉搏
     */
    private String pulse;
    /**
     * 左侧收缩压
     */
    private String lsbp;
    /**
     * 左侧舒缓压
     */
    private String lsrp;
    /**
     * 右侧收缩压
     */
    private String rsbp;
    /**
     * 右侧舒缓压
     */
    private String rsrp;
    /**
     * 身高
     */
    private String hight;
    /**
     * 体重
     */
    private String weight;
    /**
     * 体质指数
     */
    private String bmi;
    /**
     * 腰围
     */
    private String waistline;
    /**
     * 医生ID
     */
    private String doctorid;
    /**
     * 锻炼频率ID
     */
    private Integer exefreid;
    /**
     * 吸烟情况ID
     */
    private Integer smokeid;
    /**
     * 饮酒情况ID
     */
    private Integer drinkid;
    /**
     * 性别表ID
     */
    private Integer sexid;
    /**
     * 听力ID
     */
    private Integer lintenid;
    /**
     * 左眼视力
     */
    private String lacuity;
    /**
     * 右眼视力
     */
    private String racuity;
    /**
     * 左眼矫正视力
     */
    private String clv;
    /**
     * 右眼矫正视力
     */
    private String crv;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getLsbp() {
        return lsbp;
    }

    public void setLsbp(String lsbp) {
        this.lsbp = lsbp;
    }

    public String getLsrp() {
        return lsrp;
    }

    public void setLsrp(String lsrp) {
        this.lsrp = lsrp;
    }

    public String getRsbp() {
        return rsbp;
    }

    public void setRsbp(String rsbp) {
        this.rsbp = rsbp;
    }

    public String getRsrp() {
        return rsrp;
    }

    public void setRsrp(String rsrp) {
        this.rsrp = rsrp;
    }

    public String getHight() {
        return hight;
    }

    public void setHight(String hight) {
        this.hight = hight;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public Integer getExefreid() {
        return exefreid;
    }

    public void setExefreid(Integer exefreid) {
        this.exefreid = exefreid;
    }

    public Integer getSmokeid() {
        return smokeid;
    }

    public void setSmokeid(Integer smokeid) {
        this.smokeid = smokeid;
    }

    public Integer getDrinkid() {
        return drinkid;
    }

    public void setDrinkid(Integer drinkid) {
        this.drinkid = drinkid;
    }

    public Integer getSexid() {
        return sexid;
    }

    public void setSexid(Integer sexid) {
        this.sexid = sexid;
    }

    public Integer getLintenid() {
        return lintenid;
    }

    public void setLintenid(Integer lintenid) {
        this.lintenid = lintenid;
    }

    public String getLacuity() {
        return lacuity;
    }

    public void setLacuity(String lacuity) {
        this.lacuity = lacuity;
    }

    public String getRacuity() {
        return racuity;
    }

    public void setRacuity(String racuity) {
        this.racuity = racuity;
    }

    public String getClv() {
        return clv;
    }

    public void setClv(String clv) {
        this.clv = clv;
    }

    public String getCrv() {
        return crv;
    }

    public void setCrv(String crv) {
        this.crv = crv;
    }

}

