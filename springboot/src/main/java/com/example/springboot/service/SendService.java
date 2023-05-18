package com.example.springboot.service;

import com.example.springboot.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalTime;

/**
 * @author huawuque
 * @version 1.0
 * @project springboot
 * @description 到点取消
 * @date 2023/5/18 19:32:57
 */
@Service
public class SendService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public Boolean sendToBePaid(String oid){
        //Rabbit延时队列，处理订单自动取消
        try {
            rabbitTemplate.convertAndSend(
                    RabbitMQConfig.orderExchange,
                    RabbitMQConfig.routingKeyOrder,
                    oid
                    , message -> {
                        message.getMessageProperties().setExpiration(1000 * 1800 + "");
                        return message;
                    });
            System.out.println("发送成功"+ LocalTime.now());
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
