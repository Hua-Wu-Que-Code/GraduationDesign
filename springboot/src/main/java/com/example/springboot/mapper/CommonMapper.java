package com.example.springboot.mapper;

import com.example.springboot.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 通用查找类
 * @date 2023/4/20 17:14:59
 */
@Mapper
public interface CommonMapper {
    @Select("select * from disease")
    List<Disease> healthCareInfoDisease();

    @Select("select * from disease where id = #{id}")
    Disease diseaseInfo(int id);

    /*@Select("select * from user_disease where userID = #{userId}")
    @Results(value = {
            @Result(
                    property = "diseases",
                    column = "diseaseID",
                    one = @One(select = "com.example.springboot.mapper.CommonMapper.diseaseInfo")
            )
    })
    List<Disease> userInfoDisease(String userId);*/

    @Select("select * from user_disease where userID = #{userId}")
    List<UserDisease> userInfoUserDisease(String userId);

    @Select("select * from user_disability where userId = #{userId}")
    List<UserDisability> userInfoUserDisability(String userId);

    @Select("select * from disability")
    List<Disability> healthCareInfoUserDisability();

    @Select("select * from user_allergy where userID = #{id}")
    List<UserAllergy> userInfoUserAllergy(String userId);

    @Select("select * from heritage_disease")
    List<HeritageDisease> healthCareInfoHeritageDisease();

    @Select("select * from user_heritage where userId = #{id}")
    List<UserHeritage> userInfoUserHeritage(String userId);

    @Select("select name from bloodType where id = #{bloodtypeid}")
    String userInfoBloodType(Integer bloodtypeid);

    @Select("select name from education where id = #{educationId}")
    String userInfoEducation(Integer educationId);


    @Select("select name from ethnicGroup where id = #{ethnicgroupid}")
    String userInfoEthnicGroup(Integer ethnicgroupid);

    @Select("select name from pamentMeth where id = #{pamentmethId}")
    String userInfoPamentMeth(Integer pamentmethId);

    @Select("select name from marriage where id = #{marriageId}")
    String userInfoMarrage(Integer marriageId);

    @Select("select name from sex where id = #{sexId}")

    String userInfoSex(Integer sexId);
    @Select("select name from work where id = #{workId}")
    String userInfoWork(Integer workId);

    @Select("select nickname from user where id = #{userId}")
    String getUserName(String userId);

    @Select("select doctorID from user_clinic where clinicID = #{id}")
    String findDoctorByClinicId(String id);

    @Select("select clinicID from user_clinic where doctorID = #{id}")
    String findClinicByDoctorId(String id);

    @Select("select addressID from user_address where userID = #{clinicId}")
    int findAddressIDByUserId(String clinicId);

    @Select("select * from address where id = #{addressID}")
    Address findAddressByID(int addressID);

    @Select("select * from schedule where id = #{id}")
    Schedule findScheduleById(int id);

    @Update("update supplier_drug set price = #{price}  where supplierId = #{supplierId} and drugId = #{drugid}")
    void supplierUpgradeDrug(String supplierId, String drugid, Double price);

    @Update("update supplier_drug set num = #{i}  where supplierId = #{supplierId} and drugId = #{drugid}")
    void supplierAddDrug(String supplierId, String drugid, int i);

    @Select("select * from supplier_drug where supplierId = #{supplierId} and drugId = #{drugid}")
    SupplierDrug findSupplierById(String supplierId, String drugid);

    @Select("select * from exeFre")
    ArrayList<Exefre> findExeFre();

    @Select("select * from smoke")
    ArrayList<Smoke> findSmoke();

    @Select("select * from drink")
    ArrayList<Drink> findDrinks();



    @Select("select * from sport")
    ArrayList<Sport> findSports();

    @Select("select * from sex")
    ArrayList<Sex> findSex();

    @Select("select * from drink")
    ArrayList<Lip> findLips();

    @Select("select * from lintening")
    ArrayList<Lintening> findListenings();

    @Select("select * from pharynx")
    ArrayList<Pharynx> findPharynxes();


    @Select("select * from healthRecord where userID =#{userid}")
    Healthrecord findHealthCordByUserId(String userid);
}
