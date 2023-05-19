package com.example.springboot.mapper;

import com.example.springboot.entity.Clinic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 诊所的mapper类
 * @date 2023/4/27 15:28:34
 */
@Mapper
public interface ClinicMapper {
    @Select("select * from clinic limit #{page},#{limit} ")
    List<Clinic> findClinicAdmin(int page, int limit);

    @Select("select * from clinic where id = #{clinicId}")
    Clinic findClinicById(String clinicId);

    @Insert("insert into clinic_drug(clinicId,drugId,num) values(#{clinicId},#{drugId},#{num})")
    void insertClinicDrug(String clinicId,String drugId,int num);

    @Update("upgrade clinic_drug set num=#{i} where clinicId = #{clinicId} and drugId = #{drugId}")
    void upgradeClinicDrug(String clinicId, String drugId, int i);
}
