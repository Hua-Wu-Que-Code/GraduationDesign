package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 诊所药品对应表(ClinicDrug)实体类
 *
 * @author huawuque
 * @since 2023-05-18 02:04:15
 */
public class ClinicDrug implements Serializable {
    private static final long serialVersionUID = -46125383693163770L;
    /**
     * 诊所ID
     */
    private String clinicid;
    /**
     * 药品Id
     */
    private String drugid;
    /**
     * 药品数量
     */
    private Integer num;
    /**
     * 表id
     */
    private Integer id;

    private Drug drug;

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public String getClinicid() {
        return clinicid;
    }

    public void setClinicid(String clinicid) {
        this.clinicid = clinicid;
    }

    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {
        this.drugid = drugid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

