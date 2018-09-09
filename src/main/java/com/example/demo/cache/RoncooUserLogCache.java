package com.example.demo.cache;

import com.example.demo.bean.RoncooUserLog;

/**
 * 测试缓存的接口
 * @author: monkey
 * @date: 2018/9/8 13:43
 */
public interface RoncooUserLogCache {

    RoncooUserLog selectById(Integer id);

    RoncooUserLog updateById(RoncooUserLog roncooUserLog);

    String deleteById(Integer id);

}
