package com.example.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jms.annotation.EnableJms;

//默认会扫描本包和子包中的所有类
@SpringBootApplication
@ServletComponentScan //支持WebServlet、WebFilter、WebListener注解自动注册
@EnableCaching //开启缓存支持
@EnableJms //开启JMS
@EnableRabbit //开启RabbitMQ支持
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
