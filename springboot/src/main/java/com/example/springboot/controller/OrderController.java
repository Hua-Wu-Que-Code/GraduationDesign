package com.example.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.config.RabbitMQConfig;
import com.example.springboot.entity.*;
import com.example.springboot.entity.eneityVO.ListVo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalTime;
import java.util.*;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 订单控制类
 * @date 2023/5/18 17:51:42
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    RabbitTemplate rabbitTemplate;


    /**
     * 新增订单
     * @return
     */
    @RequestMapping("/newOrder")
    @CrossOrigin
    @ResponseBody
    public Result newOrder(@RequestBody Map map) {

        String id = new String();
        id = (String) request.getAttribute("id");
        Object map1 = new Object();
        ArrayList<OrderOld> order = (ArrayList<OrderOld>) map.get("order");
        String s = JSON.toJSONString(order);
        List<OrderItem> orderList = JSONObject.parseArray(s, OrderItem.class);
        OrderOld newOrder = new OrderOld(UUID.randomUUID().toString());
        Double total = new Double(0);
        String orderId = newOrder.getId();
        orderList.forEach(item-> {
            String itemId = UUID.randomUUID().toString();
            orderMapper.insertOrderItem(itemId,orderId,item.getBuynum(),item.getItemmony(),item.getSupplierid(),item.getDrugid(),item.getPrice(),0);
        });
        Date date = new Date(System.currentTimeMillis());
        for(int i =0;i<orderList.size();i++) total+=orderList.get(i).getItemmony();
        orderMapper.insertOrder(orderId,total,date,id);
        return Result.succeed("成功");

    }

    /**
     * 新增订单
     * @return
     */
    @RequestMapping("/newOrderNoPay")
    @CrossOrigin
    @ResponseBody
    public Result newOrderNoPay(@RequestBody Map map) {

        String id = new String();
        id = (String) request.getAttribute("id");
        Object map1 = new Object();
        ArrayList<OrderOld> order = (ArrayList<OrderOld>) map.get("order");
        String s = JSON.toJSONString(order);
        List<OrderItem> orderList = JSONObject.parseArray(s, OrderItem.class);
        OrderOld newOrder = new OrderOld(UUID.randomUUID().toString());
        Double total = new Double(0);
        String orderId = newOrder.getId();
        orderList.forEach(item-> {
            String itemId = UUID.randomUUID().toString();
            orderMapper.insertOrderItem(itemId,orderId,item.getBuynum(),item.getItemmony(),item.getSupplierid(),item.getDrugid(),item.getPrice(),1);
        });
        Date date = new Date(System.currentTimeMillis());
        for(int i =0;i<orderList.size();i++) total+=orderList.get(i).getItemmony();
        orderMapper.insertOrderNoPay(orderId,total,date,id,1);
        boolean flag =  sendService.sendToBePaid(orderId);
        return Result.succeed();

    }

    /**
     * 查询医生用户所有订单
     * @return
     */
    @RequestMapping("/clinicOrderList")
    @CrossOrigin
    @ResponseBody
    public Result clinicOrderList(@RequestBody ListQuery query) {
        String id = (String) request.getAttribute("id");
        ArrayList<String> status = new ArrayList<>();
        status.add("待发货");
        status.add("待支付");
        status.add("待收货");
        status.add("申请取消");
        status.add("订单取消");
        status.add("订单完成");
        status.add("商家取消");
        status.add("申请退货");
        status.add("同意退货");
        status.add("订单超时");
        status.add("商家拒绝");
        ArrayList<Order> drugList = orderMapper.clinicOrderList(query.getPage()-1,query.getLimit(),id);
        ArrayList<OrderItem> orderItemList = new ArrayList<>();
        drugList.forEach(item-> {
            String itemid = item.getId();
            ArrayList<OrderItem> orderItems = orderMapper.findOrderItemsByOrderId(item.getId());
            orderItems.forEach(d ->{
                String drug = d.getDrugid();
                d.setStatusStr(status.get(d.getStatus()));
                d.setSupplier(supplierService.findSupplierById(d.getSupplierid()));
                d.setDrug(drugMapper.findDrugByID(drug));
                orderItemList.add(d);
            });
        });
        TotalRest totalRest = new TotalRest(orderItemList.size(),orderItemList);
        return Result.succeed(totalRest);
    }

    /**
     * 查询供货商用户所有订单
     * @return
     */
    @RequestMapping("/supplierOrderList")
    @CrossOrigin
    @ResponseBody
    public Result drugOrderList(@RequestBody ListQuery query) {
        String id = (String) request.getAttribute("id");
        ArrayList<String> status = new ArrayList<>();
        status.add("待发货");
        status.add("待支付");
        status.add("待收货");
        status.add("申请取消");
        status.add("订单取消");
        status.add("订单完成");
        status.add("商家取消");
        status.add("申请退货");
        status.add("同意退货");
        status.add("订单超时");
        status.add("商家拒绝");
        ArrayList<OrderItem> drugList = orderMapper.drugOrderList(query.getPage()-1,query.getLimit(),id);
        drugList.forEach(item-> {
            item.setStatusStr(status.get(item.getStatus()));
            String orderId = item.getOrderid();
            String doctorId = orderMapper.findDoctorByOrderId(orderId);
            Doctor doctor = doctorMapper.findDoctorByID(doctorId);
            item.setDoctor(doctor);
        });
        TotalRest totalRest = new TotalRest(drugList.size(),drugList);
        return Result.succeed(totalRest);
    }

    /**
     * 更改订单状态
     * @return
     */
    @RequestMapping("/upgradeOrder")
    @CrossOrigin
    @ResponseBody
    public Result upgradeOrder(@RequestBody OrderItem orderItem) {
        if (orderItem.getStatus() == 5) {
            ArrayList<OrderItem> orderItem1 = orderMapper.findOrderItemsByOrderId(orderItem.getOrderid());
            orderItem1.forEach(item-> {
                String drugId = item.getDrugid();
                String supplierId =item.getSupplierid();
                String doctorId = orderMapper.findDoctorByOrderId(orderItem.getOrderid());
                String clinicId = commonMapper.findClinicByDoctorId(doctorId);
                int num = item.getBuynum();
                ClinicDrug drug = drugMapper.findClinicDrug(clinicId,drugId);
                if (drug.getNum() == 0) clinicMapper.insertClinicDrug(clinicId,drugId,num);
                else clinicMapper.upgradeClinicDrug(clinicId,drugId,num+drug.getNum());
                SupplierDrug supplierDrug = supplierMapper.findSupplierDrug(supplierId,drugId);
                supplierMapper.upgradeSupplierDrug(supplierId,drugId,supplierDrug.getNum()-num);
            });
        }
        orderMapper.upgradeOrderItemById(orderItem.getId(),orderItem.getStatus());
        return Result.succeed();
    }

}
