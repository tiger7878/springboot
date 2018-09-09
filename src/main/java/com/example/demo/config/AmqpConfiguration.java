package com.example.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AMQP消息队列配置
 * @author: monkey
 * @date: 2018/9/8 15:56
 */
//@Configuration
public class AmqpConfiguration {

    //一定要注意，这里的方法名一定不能是queue，否则不会自动创建
    @Bean
    public Queue queue1() {
        return new Queue("monkey.queue");
    }

    @Bean
    public Queue queue2() {
        return new Queue("cc.queue");
    }

    @Bean
    public Queue queue3() {
        return new Queue("aa.queue");
    }

}
