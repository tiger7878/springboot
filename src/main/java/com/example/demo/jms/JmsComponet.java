package com.example.demo.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * JMS组件，里面有生产者和消费者
 * @author: monkey
 * @date: 2018/9/8 15:23
 */
@Component
public class JmsComponet {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;//注入配置的队列

    //发送消息
    public void send(String msg){
        this.jmsMessagingTemplate.convertAndSend(this.queue,msg);
    }

    //接收处理消息
    @JmsListener(destination = "monkey.queue")
    public void receiveQueue(String txt){
        System.out.println("处理activemq的消息："+txt);
    }

}
