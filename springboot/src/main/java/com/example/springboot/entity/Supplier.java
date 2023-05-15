package com.example.springboot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 供货商表(Supplier)实体类
 *
 * @author huawuque
 * @since 2023-05-15 19:59:39
 */
public class Supplier implements Serializable {
    private static final long serialVersionUID = 425953965437108681L;
    /**
     * 供货商ID
     */
    private String id;
    /**
     * 供货商名称
     */
    private String name;
    /**
     * 供货商注册时间
     */
    private Date date;
    /**
     * 供货商许可
     */
    private String approvaltoken;

    private String address;

    private User user;

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getApprovaltoken() {
        return approvaltoken;
    }

    public void setApprovaltoken(String approvaltoken) {
        this.approvaltoken = approvaltoken;
    }

}

