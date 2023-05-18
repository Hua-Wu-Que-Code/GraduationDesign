package com.example.springboot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 返回总数的实体类
 * @date 2023/5/18 02:02:12
 */
@Data
public class TotalRest implements Serializable {
    private int total;
    private Object List;

    public TotalRest(int total, Object data) {
        this.total = total;
        this.List = data;
    }
}
