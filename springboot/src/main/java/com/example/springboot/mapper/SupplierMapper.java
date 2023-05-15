package com.example.springboot.mapper;

import com.example.springboot.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
