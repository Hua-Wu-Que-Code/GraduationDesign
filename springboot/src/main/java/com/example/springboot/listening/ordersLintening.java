package com.example.springboot.listening;



import com.example.springboot.config.RabbitMQConfig;
import com.example.springboot.entity.Order;
import com.example.springboot.mapper.OrderMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ordersLintening {

    @Autowired
    OrderMapper orderMapper;

    @RabbitListener(queues = RabbitMQConfig.dealQueueOrder)
    public void processOrders(String oid){
        orderMapper.upgradeOrderById(oid,9);
    }
}
