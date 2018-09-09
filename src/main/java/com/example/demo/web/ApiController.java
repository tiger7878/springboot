package com.example.demo.web;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试支持跨域访问的资源
 * @author: monkey
 * @date: 2018/9/5 21:13
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    //细粒度的跨域支持，写到单个方法上
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public Map<String,String> get(@RequestParam String name){
        Map<String,String> map=new HashMap<>();
        map.put("title","hello world");
        map.put("name",name);
        return map;
    }

}
