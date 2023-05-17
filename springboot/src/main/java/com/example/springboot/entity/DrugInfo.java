package com.example.springboot.entity;

import java.io.Serializable;

/**
 * 药品信息表(Druginfo)实体类
 *
 * @author huawuque
 * @since 2023-05-17 14:45:06
 */
public class DrugInfo implements Serializable {
    private static final long serialVersionUID = -62826613254849269L;
    /**
     * 药品ID
     */
    private String drugid;
    /**
     * 药品名称
     */
    private String drugName;
    /**
     * 禁忌
     */
    private String jj;
    /**
     * 形状
     */
    private String xz;
    /**
     * 商品名称
     */
    private String spmc;
    /**
     * 形状
     */
    private String jx;
    /**
     * 适用症
     */
    private String syz;
    /**
     * 用法用量
     */
    private String yfyl;
    /**
     * 主要成分
     */
    private String zycf;
    /**
     * 注意事项
     */
    private String zysx;
    /**
     * 儿童用药
     */
    private String etyy;
    /**
     * 规格
     */
    private String gg;
    /**
     * 孕妇及哺乳期妇女慎用
     */
    private String yfjbrqfnyy;
    /**
     * 生产厂家
     */
    private String manu;
    /**
     * 贮存
     */
    private String zc;
    /**
     * 汉语拼音
     */
    private String hypy;
    /**
     * 通用名称
     */
    private String tymc;
    /**
     * 批准文号
     */
    private String pzwh;
    /**
     * 执行标准
     */
    private String zxbz;
    /**
     * 药物相互作用
     */
    private String ywxhzy;
    /**
     * 有效期
     */
    private String yxq;
    /**
     * 不良反应
     */
    private String blfy;
    /**
     * 论文引用
     */
    private String lryy;
    /**
     * 价格
     */
    private String price;


    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {
        this.drugid = drugid;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getJj() {
        return jj;
    }

    public void setJj(String jj) {
        this.jj = jj;
    }

    public String getXz() {
        return xz;
    }

    public void setXz(String xz) {
        this.xz = xz;
    }

    public String getSpmc() {
        return spmc;
    }

    public void setSpmc(String spmc) {
        this.spmc = spmc;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getSyz() {
        return syz;
    }

    public void setSyz(String syz) {
        this.syz = syz;
    }

    public String getYfyl() {
        return yfyl;
    }

    public void setYfyl(String yfyl) {
        this.yfyl = yfyl;
    }

    public String getZycf() {
        return zycf;
    }

    public void setZycf(String zycf) {
        this.zycf = zycf;
    }

    public String getZysx() {
        return zysx;
    }

    public void setZysx(String zysx) {
        this.zysx = zysx;
    }

    public String getEtyy() {
        return etyy;
    }

    public void setEtyy(String etyy) {
        this.etyy = etyy;
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getYfjbrqfnyy() {
        return yfjbrqfnyy;
    }

    public void setYfjbrqfnyy(String yfjbrqfnyy) {
        this.yfjbrqfnyy = yfjbrqfnyy;
    }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }

    public String getZc() {
        return zc;
    }

    public void setZc(String zc) {
        this.zc = zc;
    }

    public String getHypy() {
        return hypy;
    }

    public void setHypy(String hypy) {
        this.hypy = hypy;
    }

    public String getTymc() {
        return tymc;
    }

    public void setTymc(String tymc) {
        this.tymc = tymc;
    }

    public String getPzwh() {
        return pzwh;
    }

    public void setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }

    public String getZxbz() {
        return zxbz;
    }

    public void setZxbz(String zxbz) {
        this.zxbz = zxbz;
    }

    public String getYwxhzy() {
        return ywxhzy;
    }

    public void setYwxhzy(String ywxhzy) {
        this.ywxhzy = ywxhzy;
    }

    public String getYxq() {
        return yxq;
    }

    public void setYxq(String yxq) {
        this.yxq = yxq;
    }

    public String getBlfy() {
        return blfy;
    }

    public void setBlfy(String blfy) {
        this.blfy = blfy;
    }

    public String getLryy() {
        return lryy;
    }

    public void setLryy(String lryy) {
        this.lryy = lryy;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

