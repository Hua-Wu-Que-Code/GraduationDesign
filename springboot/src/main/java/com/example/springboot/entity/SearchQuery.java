package com.example.springboot.entity;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 药品查找类
 * @date 2023/5/17 21:25:15
 */
public class SearchQuery {
    private String title;
    private String type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
