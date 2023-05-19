package com.example.springboot.mapper;

import com.example.springboot.entity.Supplier;
import com.example.springboot.entity.SupplierDrug;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 供货商Mapper
 * @date 2023/5/15 20:00:57
 */
@Mapper
public interface SupplierMapper {
    @Select("select * from supplier limit #{page},#{limit} ")
    List<Supplier> findSuppliersAdmin(int page, int limit);

    @Select("select * from supplier where  id=#{supplierId}")
    Supplier findSupplierById(String supplierId);

    @Insert("insert into supplier_drug(supplierId,drugId,num,price) values(#{supplierId},#{drugId},#{num},#{price})")
    void InsertSupplierDrug(String supplierId,String drugId,int num,Double price);

    @Select("select * from supplier_drug where supplierId=#{supplierId} and drugId = #{drugId}")
    SupplierDrug findSupplierDrug(String supplierId, String drugId);

    @Update("upgrade supplier_drug set num=#{i} where supplierId=#{supplierId} and drugId = #{drugId}")
    void upgradeSupplierDrug(String supplierId, String drugId, int i);
}
