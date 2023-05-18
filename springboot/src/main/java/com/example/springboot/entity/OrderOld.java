package com.example.springboot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author huawuque
 * @since 2023-05-18 17:20:38
 */
public class OrderOld implements Serializable {
    private static final long serialVersionUID = 157935681409085846L;
    /**
     * 订单表ID
     */
    private String id;
    /**
     * 订单总价
     */
    private Double total;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 结束时间
     */
    private Date closetime;
    /**
     * 用户Id
     */
    private String doctorid;


    public OrderOld(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getClosetime() {
        return closetime;
    }

    public void setClosetime(Date closetime) {
        this.closetime = closetime;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

}

