package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 异常处理方案一：自定义错误控制器
 * 备注：欢迎下面的两个注释就启用了
 * @author: monkey
 * @date: 2018/9/2 22:38
 */
//@Controller
//@RequestMapping("/error")
public class BaseErrorController implements ErrorController {

    public static final Logger LOGGER= LoggerFactory.getLogger(BaseErrorController.class);

    @Override
    public String getErrorPath() {
        LOGGER.info("出错了，进入自定义错误控制器！");
        return "error/error";
    }

    @RequestMapping
    public String error(){
        return getErrorPath();
    }

}
