package com.example.demo.service;

import com.example.demo.bean.RoncooUser;
import com.example.demo.bean.RoncooUserLog;
import com.example.demo.dao.RoncooUserDao;
import com.example.demo.dao.RoncooUserLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author: monkey
 * @date: 2018/9/8 10:16
 */
@Service
public class UserService {

    @Autowired
    private RoncooUserDao roncooUserDao;

    @Autowired
    private RoncooUserLogDao roncooUserLogDao;

    @Transactional
    public String register(String name,String ip){
        RoncooUser roncooUser=new RoncooUser();
        roncooUser.setName(name);
        roncooUser.setCreateTime(new Date());

        roncooUserDao.save(roncooUser);

        /*if (true){
            throw new RuntimeException("自己抛出的异常！");
        }*/

        RoncooUserLog roncooUserLog=new RoncooUserLog();
        roncooUserLog.setUserName(name);
        roncooUserLog.setUserIp(ip);
        roncooUserLog.setCreateTime(new Date());
        roncooUserLogDao.save(roncooUserLog);

        return "success";
    }

}
