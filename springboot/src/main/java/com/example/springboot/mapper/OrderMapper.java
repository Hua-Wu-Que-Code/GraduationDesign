package com.example.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;


/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 订单相关mapper
 * @date 2023/5/18 17:52:35
 */
@Mapper
public interface OrderMapper {
    @Insert(" insert into order_item(id,orderId,buyNum,itemMony,supplierId,drugId,price) values (#{itemId},#{orderId},#{buynum},#{itemmony},#{supplierid},#{drugid},#{price})")
    void insertOrderItem(String itemId, String orderId, Integer buynum, Double itemmony, String supplierid, String drugid, Double price);

    @Insert("insert into order_new(id,createTime,total,doctorId) values (#{orderId},#{createTime},#{total}, #{id})")
    void insertOrder(String orderId, Double total, Date createTime, String id);
}
