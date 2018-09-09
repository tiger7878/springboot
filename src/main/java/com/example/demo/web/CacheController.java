package com.example.demo.web;

import com.example.demo.bean.RoncooUserLog;
import com.example.demo.cache.RoncooUserLogCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试缓存
 * @author: monkey
 * @date: 2018/9/8 13:55
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private RoncooUserLogCache roncooUserLogCache;

    @RequestMapping("/get")
    public RoncooUserLog get(@RequestParam(defaultValue = "1") Integer id){
        return roncooUserLogCache.selectById(id);
    }

    @RequestMapping("/update")
    public RoncooUserLog update(@RequestParam(defaultValue = "1") Integer id){
        RoncooUserLog model=roncooUserLogCache.selectById(id);
        model.setUserName("测试");
        model.setCreateTime(new Date());

        roncooUserLogCache.updateById(model);
        return model;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(defaultValue = "1") Integer id){
        return roncooUserLogCache.deleteById(id);
    }

}
