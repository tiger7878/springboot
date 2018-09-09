package com.example.demo.web;

import com.example.demo.bean.RoncooUserLog;
import com.example.demo.cache.RoncooUserLogCache;
import com.example.demo.dao.RoncooUserLogDao;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Rest服务
 * @author: monkey
 * @date: 2018/9/8 20:58
 */
@RestController
@RequestMapping("/rest")
public class MyRestController {

    @Autowired
    private RoncooUserLogCache roncooUserLogCache;

    @RequestMapping(value = "/update1/{id}",method = RequestMethod.GET)
    public RoncooUserLog update1(@PathVariable Integer id){

        RoncooUserLog model=roncooUserLogCache.selectById(id);

        if (model==null){
            model=new RoncooUserLog();
        }

        model.setUserName("测试1");
        model.setCreateTime(new Date());
        model.setUserIp("192.168.1.1");

        roncooUserLogCache.updateById(model);

        return model;
    }

    @RequestMapping(value = "/update2",method = RequestMethod.POST)
    public RoncooUserLog update(@RequestBody JsonNode jsonNode){
        //请求参数是json格式的字符串
        System.out.println("jsonnode = "+jsonNode);

        RoncooUserLog model=roncooUserLogCache.selectById(jsonNode.get("id").asInt(1));

        if (model==null){
            model=new RoncooUserLog();
        }

        model.setUserName("测试2");
        model.setCreateTime(new Date());
        model.setUserIp("192.168.1.2");

        roncooUserLogCache.updateById(model);

        return model;
    }

}
