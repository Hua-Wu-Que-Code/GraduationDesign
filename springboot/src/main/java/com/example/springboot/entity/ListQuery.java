package com.example.springboot.entity;

import lombok.Data;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description 查询对象
 * @date 2023/4/13 21:21:40
 */
@Data
public class ListQuery {
    int page;
    int limit;
    String importance;
    String title;
    String type;

}
