package com.example.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义缓存管理器
 * @author: monkey
 * @date: 2018/9/8 14:29
 */
@Configuration
public class RedisCacheConfiguration extends CachingConfigurerSupport{

    //缓存管理器
    @Bean
    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate){
        RedisCacheManager cacheManager=new RedisCacheManager(redisTemplate);
        //设置默认过期时间
        cacheManager.setDefaultExpiration(20);
        //单独设置某一些key的过期时间
        Map<String,Long> expires=new HashMap<>();
        expires.put("roncooCache",200L);//单位是秒
        cacheManager.setExpires(expires);
        return cacheManager;
    }

    /**
     * 自定义key. 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key,即使@Cacheable中的value属性一样，key也会不一样。
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        return new MyKeyGenerator();
    }
}
