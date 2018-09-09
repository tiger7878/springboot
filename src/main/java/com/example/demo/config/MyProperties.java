package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 读取application.properties中的值
 * @author: monkey
 * @date: 2018/9/2 11:38
 */
@Component
public class MyProperties {

    @Value("${roncoo.secret}")
    private String secret;

    @Value("${roncoo.number}")
    private String number;

    @Value("${roncoo.name}")
    private String name;

    @Value("${roncoo.desc}")
    private String desc;

    public String getSecret() {
        return secret;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
