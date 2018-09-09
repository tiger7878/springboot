package com.example.demo.amqp;

import com.example.demo.config.AmqpConfiguration;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ组件，里面发送和接收消息
 * @author: monkey
 * @date: 2018/9/8 16:02
 */
//@Component
//@AutoConfigureAfter(AmqpConfiguration.class)
public class AmqpComponet {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg) {
        this.amqpTemplate.convertAndSend("monkey.queue", msg);
    }

    @RabbitListener(queues = "monkey.queue")
    public void receiveQueue(String text) {
        System.out.println("接受到：" + text);
    }

}
