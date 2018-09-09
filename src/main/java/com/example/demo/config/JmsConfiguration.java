package com.example.demo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * JMS的配置
 * @author: monkey
 * @date: 2018/9/8 15:19
 */
@Configuration
public class JmsConfiguration {

    @Bean
    public Queue queue(){
        //创建一个队列，指定队列名称monkey.queue
        return new ActiveMQQueue("monkey.queue");
    }

}
