package com.example.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.entity.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
            orderMapper.insertOrderItem(itemId,orderId,item.getBuynum(),item.getItemmony(),item.getSupplierid(),item.getDrugid(),item.getPrice());
        });
        Date date = new Date(System.currentTimeMillis());
        for(int i =0;i<orderList.size();i++) total+=orderList.get(i).getItemmony();
        orderMapper.insertOrder(orderId,total,date,id);
        return Result.succeed("成功");

    }
}
