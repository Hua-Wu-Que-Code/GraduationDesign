package com.example.springboot.mapper;

import com.example.springboot.entity.Medicalexaminationfile;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description
 * @date 2023/5/19 20:02:44
 */
@Mapper
public interface MedicalexaminationfileMapper {


    void insert(Medicalexaminationfile medicalexaminationfile);
}
