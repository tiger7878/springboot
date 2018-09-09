package com.example.demo.config;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * 自定义缓存key生成策略
 * @author: monkey
 * @date: 2018/9/8 14:53
 */
public class MyKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object o, Method method, Object... objects) {
        StringBuilder sb = new StringBuilder();
        sb.append(o.getClass().getName());
        sb.append(method.getName());
        for (Object obj : objects) {
            sb.append(obj.toString());
        }
        System.out.println("自定义缓存key = "+sb.toString());
        return sb.toString();
    }

}
