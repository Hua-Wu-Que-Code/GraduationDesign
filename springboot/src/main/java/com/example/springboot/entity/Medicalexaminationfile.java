package com.example.springboot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 体检信息表(Medicalexaminationfile)实体类
 *
 * @author huawuque
 * @since 2023-04-16 22:21:12
 */
public class Medicalexaminationfile implements Serializable {
    private static final long serialVersionUID = 822781169489078366L;
    /**
     * 健康体检表id
     */
    private Integer id;
    /**
     * 体检地点名
     */
    private String nickname;
    /**
     * 时间
     */
    private Date date;
    /**
     * 体检单位图像
     */
    private String src;
    /**
     * 体检描述
     */
    private String description;
    /**
     * 体检详细表id
     */
    private Integer detailinfo;
    /**
     * 体检单位ID
     */
    private String clincid;
    /**
     * 体检人ID
     */
    private String userid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDetailinfo() {
        return detailinfo;
    }

    public void setDetailinfo(Integer detailinfo) {
        this.detailinfo = detailinfo;
    }

    public String getClincid() {
        return clincid;
    }

    public void setClincid(String clincid) {
        this.clincid = clincid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

}

