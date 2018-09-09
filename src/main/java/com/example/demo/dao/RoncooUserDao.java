package com.example.demo.dao;

import com.example.demo.bean.RoncooUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: monkey
 * @date: 2018/9/8 10:14
 */
public interface RoncooUserDao extends JpaRepository<RoncooUser,Integer>{
}
