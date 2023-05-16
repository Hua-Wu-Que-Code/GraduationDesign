package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * 时间表(Schedule)实体类
 *
 * @author huawuque
 * @since 2023-05-16 19:15:56
 */
public class Schedule implements Serializable {
    private static final long serialVersionUID = 295459979914307679L;
    /**
     * 时间表ID

     */
    @JsonIgnore
    private Integer id;
    /**
     * 年份:默认2016
     */
    private String year;
    /**
     * 月份:默认9
     */
    private String month;
    /**
     * 时间:默认10
     */
    private String date;
    /**
     * 开启小时
     */
    private String hours;
    /**
     * 分钟
     */
    private String minutes;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

}

