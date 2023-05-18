package com.example.springboot.mapper;

import com.example.springboot.entity.ListQuery;
import com.example.springboot.entity.Order;
import com.example.springboot.entity.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;
import java.util.ArrayList;


/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 订单相关mapper
 * @date 2023/5/18 17:52:35
 */
@Mapper
public interface OrderMapper {
    @Insert(" insert into order_item(id,orderId,buyNum,itemMony,supplierId,drugId,price,status) values (#{itemId},#{orderId},#{buynum},#{itemmony},#{supplierid},#{drugid},#{price},#{status})")
    void insertOrderItem(String itemId, String orderId, Integer buynum, Double itemmony, String supplierid, String drugid, Double price,int status);

    @Insert("insert into order_new(id,createTime,total,doctorId) values (#{orderId},#{createTime},#{total}, #{id})")
    void insertOrder(String orderId, Double total, Date createTime, String id);

    @Insert("insert into order_new(id,createTime,total,doctorId,status) values (#{orderId},#{date},#{total}, #{id},#{i})")
    void insertOrderNoPay(String orderId, Double total, Date date, String id, int i);

    @Select("select * from order_new where id = #{oid}")
    Order findOrderById(String oid);

    @Select("select * from order_item where orderId = #{oid}")
    ArrayList<OrderItem> findOrderItemsByOrderId(String oid);

    @Update("update order_new set status = #{i} where id = #{oid}")
    void upgradeOrderById(String oid,int i);

    @Update("update order_item set status = #{i} where id = #{oid}")
    void upgradeOrderItemById(String oid,int i);

    @Select("select * from order_new where doctorId = #{id} limit #{page},#{limit} ")
    ArrayList<Order> clinicOrderList(int page,int limit, String id);
    @Select("select * from order_item where supplierId = #{id} limit #{page},#{limit} ")
    ArrayList<OrderItem> drugOrderList(int page ,int limit,String id);

    @Select("select doctorId from order_new where id = #{orderId}")
    String findDoctorByOrderId(String orderId);
}
