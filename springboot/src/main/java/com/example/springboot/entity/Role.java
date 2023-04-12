package com.example.springboot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author huawuque
 * @since 2023-03-14 15:20:18
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -23098833595769440L;
    /**
     * 权限id
     */
    private Integer id;
    /**
     * 权限名
     */
    private String name;
    /**
     * 权限详细
     */
    private String introduction;
}

