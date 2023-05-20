package com.example.springboot.mapper;

import com.example.springboot.entity.Cureorderitem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description
 * @date 2023/5/19 23:03:07
 */
@Mapper
public interface CureorderitemMapper {
    void insert(Cureorderitem item);
}
