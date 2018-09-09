package com.example.demo.componet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * @author: monkey
 * @date: 2018/9/8 11:12
 */
@Component
public class RoncooRedisComponent {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key,String value){
        ValueOperations<String,String> ops=this.stringRedisTemplate.opsForValue();
        if (!this.stringRedisTemplate.hasKey(key)){
            ops.set(key,value);
            System.out.println("set key success");
        }else {
            //打印之前的值
            System.out.println("this key = "+ops.get(key));
        }
    }

    public String get(String key){
        return this.stringRedisTemplate.opsForValue().get(key);
    }

    public void del(String key){
        this.stringRedisTemplate.delete(key);
    }

}
