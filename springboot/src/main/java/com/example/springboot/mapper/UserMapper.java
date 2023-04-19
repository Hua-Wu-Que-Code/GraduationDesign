package com.example.springboot.mapper;

import com.example.springboot.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project GraduationDesign
 * @description user 的Mapepr类
 * @date 2023/3/9 21:25:15
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User findUserById(String id);


    @Select("select * from user where username = #{username}")
    User findUserByUserName(String username);

    @Select("select * from user limit #{page},#{limit} ")
    List<User> findUsersAdmin(int page,int limit);

    @Delete("delete from user where id = #{id}")
    int forEachDelete(String id);

    @Select("select * from MedicalExaminationFile where userID = #{id}")
    List<Medicalexaminationfile> fetchMedicalExaminationFile(String id);

    @Select("select * from healthRecord where userID = #{userId} ")
    Healthrecord findHealthRecord(String userId);

    @Select("select * from ethnicGroup ")
    List<Ethnicgroup> healthCareInfoEthnicGroup();

    @Select("select * from bloodType ")
    List<Bloodtype> healthCareInfoBloodType();

    @Select("select * from education ")
    List<Education> healthCareInfoEducation();

    @Select("select * from marriage ")
    List<Marriage> healthCareInfoMarriage();

    @Select("select * from  pamentMeth")
    List<Pamentmeth> healthCareInfoPamentMeth();

    @Select("select * from allergyHistory ")
    List<Allergyhistory> healthCareInfoAllergyHistory();

    @Select("select * from work ")
    List<Work> healthCareInfoWorks();

    @Select("select * from sex ")
    List<Sex> healthCareInfoSex();
}
