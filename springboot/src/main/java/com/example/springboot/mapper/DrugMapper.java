package com.example.springboot.mapper;

import com.example.springboot.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 药品mapper类
 * @date 2023/5/17 00:55:32
 */
@Mapper
public interface DrugMapper {

    @Insert(" insert into drug(drugId,drugName,manu,pzwh,classifyId) values (#{drugid},#{drugname},#{manu},#{pzwh},#{classifyid})")
    void insertDrug(String drugid, String drugname, String manu, String pzwh, String classifyid);

    @Select("select * from drug limit #{page},#{limit} ")
    ArrayList<Drug> findDrugsAdmin(ListQuery query);

    @Select("select count(1) from drug")
    int total();

    @Insert(" insert into DrugClass(classname,classify,classifyid) values (#{classname},#{classify},#{classifyid})")
    void insertDrugClass(String classname, String classify, String classifyid);


    @Select("select * from drugInfo where drugId =#{id}")
    DrugInfo findDrugInfoById(String id);

    @Insert(" insert into drugInfo(drugId,drugName,jj,xz,spmc,jx,syz,yfyl,zycf,zysx,etyy,gg,yfjbrqfnyy,manu,zc,hypy,tymc,pzwh,zxbz,ywxhzy,yxq,blfy,lryy,price) " +
            "values (#{drugId},#{drugName},#{jj},#{xz},#{spmc},#{jx},#{syz},#{yfyl},#{zycf},#{zysx},#{etyy},#{gg},#{yfjbrqfnyy},#{manu},#{zc},#{hypy},#{tymc},#{pzwh},#{zxbz},#{ywxhzy},#{yxq},#{blfy},#{lryy},#{price})")
    void insertDrugInfo(String drugId, String drugName, String jj, String gg, String xz, String spmc, String jx, String syz, String yfyl, String zycf, String zysx, String etyy, String yfjbrqfnyy, String manu, String zc, String hypy, String tymc, String pzwh, String zxbz, String ywxhzy, String yxq, String blfy, String lryy, String price);


    @Update("update drug set status = #{flag} where drugId = #{id}")
    int upgradeStatus(String id, int flag);

    @Select("select * from drug where drugName =#{title}")
    List<Drug> findDrugsSearchByName(String title);

    @Select("select * from drug where drugId =#{title}")
    List<Drug> findDrugsSearchID(String title);

    @Select("select * from DrugClass where classifyid =#{classifyid}")
    Drugclass findClassById(String classifyid);

    @Select("select * from clinic_drug  where clinicId = #{clinicId} limit #{page},#{limit}")
    ArrayList<ClinicDrug> findDrugsDoctor(int page, int limit, String clinicId);

    @Select("select * from clinic_drug  where clinicId = #{clinicId}")
    ArrayList<Drug> countDrugsDoctor(String clinicId);

    @Select("select * from supplier_drug  where supplierId = #{id} limit #{page},#{limit}")
    ArrayList<SupplierDrug> findDrugssupplier(int page, int limit, String id);

    @Select("select * from supplier_drug  where supplierId = #{id}")
    Collection<Object> countDrugsSupplier(String id);

    @Select("select * from supplier_drug where drugId = #{title} limit #{page},#{limit}")
    ArrayList<SupplierDrug> findDrugsSole(int page, int limit,String title);
    @Select("select * from supplier_drug where drugId = #{title}")
    List<SupplierDrug> countDrugsSupplierSole(String title);
}
