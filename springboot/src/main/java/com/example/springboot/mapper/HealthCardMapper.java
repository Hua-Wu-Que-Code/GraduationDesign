package com.example.springboot.mapper;

import com.example.springboot.entity.Healthrecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description
 * @date 2023/5/19 21:17:38
 */
@Mapper
public interface HealthCardMapper {
    void insert(Healthrecord healthrecord);

    void update(Healthrecord healthrecord);
}
