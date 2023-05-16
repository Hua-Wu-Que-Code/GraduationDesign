package com.example.springboot.mapper;

import com.example.springboot.entity.Drug;
import com.example.springboot.entity.ListQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
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
}
