package com.example.springboot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 药品信息表(Drug)实体类
 *
 * @author huawuque
 * @since 2023-04-27 15:14:40
 */
public class Drug implements Serializable {
    private static final long serialVersionUID = -99012322383917257L;
    /**
     * 药品ID
     */
    private int id;
    /**
     * 药品名称
     */
    private String name;
    /**
     * 适用症状
     */
    private String indications;
    /**
     * 有效期
     */
    private Date expirationdate;
    /**
     * 用法用量
     */
    private String usage;
    /**
     * 批准文号
     */
    private String approvalnum;
    /**
     * 专有标志
     */
    private String marks;
    /**
     * 厂家
     */
    private String factory;
    /**
     * 药品成分
     */
    private String ingredients;
    /**
     * 存放方法
     */
    private String storage;
    /**
     * 不良反应
     */
    private String adverseactions;
    /**
     * 生产日期
     */
    private Date manufacturedate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public Date getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(Date expirationdate) {
        this.expirationdate = expirationdate;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getApprovalnum() {
        return approvalnum;
    }

    public void setApprovalnum(String approvalnum) {
        this.approvalnum = approvalnum;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getAdverseactions() {
        return adverseactions;
    }

    public void setAdverseactions(String adverseactions) {
        this.adverseactions = adverseactions;
    }

    public Date getManufacturedate() {
        return manufacturedate;
    }

    public void setManufacturedate(Date manufacturedate) {
        this.manufacturedate = manufacturedate;
    }

}

