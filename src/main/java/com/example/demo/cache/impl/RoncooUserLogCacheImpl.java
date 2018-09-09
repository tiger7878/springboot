package com.example.demo.cache.impl;

import com.example.demo.bean.RoncooUserLog;
import com.example.demo.cache.RoncooUserLogCache;
import com.example.demo.dao.RoncooUserLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @author: monkey
 * @date: 2018/9/8 13:44
 */
@CacheConfig(cacheNames = "roncooCache")
@Repository
public class RoncooUserLogCacheImpl implements RoncooUserLogCache {

    @Autowired
    private RoncooUserLogDao roncooUserLogDao;

    //这里如果写了key，那么它的生成策略高于配置类中重写的key生成策略
//    @Cacheable(key = "#p0")
//    @Cacheable(key = "#p0.intValue()")
    @Cacheable
    @Override
    public RoncooUserLog selectById(Integer id) {
        System.out.println("查询功能，缓存找不到，直接读库, id="+id);
        return roncooUserLogDao.findOne(id);
    }

//    @CachePut(key = "#p0")
//    @CachePut(key = "#p0.id")
    @CachePut
    @Override
    public RoncooUserLog updateById(RoncooUserLog roncooUserLog) {
        System.out.println("更新功能，更新缓存，直接写库, id="+roncooUserLog.getId());
        return roncooUserLogDao.save(roncooUserLog);
    }

//    @CacheEvict(key = "#p0")
//    @CacheEvict(key = "#p0.intValue()")
    @CacheEvict
    @Override
    public String deleteById(Integer id) {
        roncooUserLogDao.delete(id);
        return "删除缓存";
    }
}
