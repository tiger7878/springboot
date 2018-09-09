package com.example.demo.dao;

import com.example.demo.bean.RoncooUserLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: monkey
 * @date: 2018/9/6 22:09
 */
public interface RoncooUserLogDao extends JpaRepository<RoncooUserLog,Integer> {

    RoncooUserLog findByUserName(String userName);

}
