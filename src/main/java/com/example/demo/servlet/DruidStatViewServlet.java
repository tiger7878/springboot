package com.example.demo.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * 监控Druid需要的
 * 访问路径：/druid
 * 登录访问界面的账号和密码，好像没效果
 * @author: monkey
 * @date: 2018/9/10 22:24
 */
@WebServlet(urlPatterns = "/druid/*",
        initParams = {@WebInitParam(name = "loginUsername",value = "monkey"),
            @WebInitParam(name = "loginPassword",value = "123")})
public class DruidStatViewServlet extends StatViewServlet {

}
