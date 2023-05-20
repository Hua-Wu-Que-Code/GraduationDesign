package com.example.springboot.mapper;

import com.example.springboot.entity.Cureorder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description
 * @date 2023/5/19 23:02:06
 */
@Mapper
public interface CureOrderMapper {
    void insert(Cureorder cureorder);
}
