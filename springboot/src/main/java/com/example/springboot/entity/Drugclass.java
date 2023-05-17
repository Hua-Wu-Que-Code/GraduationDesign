package com.example.springboot.entity;

import java.io.Serializable;

/**
 * (Drugclass)实体类
 *
 * @author huawuque
 * @since 2023-05-17 03:36:03
 */
public class Drugclass implements Serializable {
    private static final long serialVersionUID = -35238080855450570L;
    /**
     * 大类别
     */
    private String classname;
    /**
     * 小类别
     */
    private String classify;
    /**
     * Id
     */
    private String classifyid;


    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getClassifyid() {
        return classifyid;
    }

    public void setClassifyid(String classifyid) {
        this.classifyid = classifyid;
    }

}

