package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 诊所医生表(UserClinic)实体类
 *
 * @author huawuque
 * @since 2023-05-15 19:30:51
 */
public class UserClinic implements Serializable {
    private static final long serialVersionUID = 821670505254511728L;
    /**
     * 诊所-医生表id
     */
    private Integer id;
    /**
     * 医生ID
     */
    private String doctorid;
    /**
     * 诊所ID
     */
    private String clinicid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public String getClinicid() {
        return clinicid;
    }

    public void setClinicid(String clinicid) {
        this.clinicid = clinicid;
    }

}

