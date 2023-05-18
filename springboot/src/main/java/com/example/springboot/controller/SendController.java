package com.example.springboot.controller;

import com.example.springboot.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;


@RestController
@CrossOrigin
public class SendController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "sendToBePaid/{oid}",method = RequestMethod.GET)
    public Boolean sendToBePaid(@PathVariable Integer oid){
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
