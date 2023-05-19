package com.example.springboot.mapper;

import com.example.springboot.entity.Doctor;
import com.example.springboot.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.ArrayList;
import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 医生的mapper 类
 * @date 2023/4/27 15:33:30
 */
@Mapper
public interface DoctorMapper {
    @Select("select * from doctor limit #{page},#{limit} ")
    List<Doctor> findDoctorsAdmin(int page, int limit);

    @Select("select * from doctor where id = #{dortorid}")
    Doctor findDoctorByID(String dortorid);

    @Select("select * from patient where doctorId = #{doctorId} limit #{page},#{limit} ")
    ArrayList<Patient> patientList(int page, int limit, String doctorId);

    @Select("select * from patient where doctorId = #{doctorId} ")
    ArrayList<Patient> allPatientList(String doctorId);
}
