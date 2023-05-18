package com.example.springboot.listening;



import com.example.springboot.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

@Component
public class ordersLintening {


    @RabbitListener(queues = RabbitMQConfig.dealQueueOrder)
    public void processOrders(String oid){

    }
}
