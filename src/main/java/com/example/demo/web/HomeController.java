package com.example.demo.web;

import com.example.demo.amqp.AmqpComponet;
import com.example.demo.bean.User;
import com.example.demo.config.MyProperties;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: monkey
 * @date: 2018/9/1 8:36
 */
//@RestController
@Controller
public class HomeController {

    //日志
    private static final Logger LOGGER= LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private MyProperties myProperties;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(ModelMap model, HttpSession session){
        model.addAttribute("myName","monkey");
        LOGGER.info("我进入了HomeController的index方法");
        LOGGER.info("sessionid = "+session.getId());
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        int j=0;
        int i=5/j;
        return "login";
    }

    @RequestMapping("/get")
    public Map<String,Object> get(@RequestParam String name){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name",name);
        map.put("value","aaa");
        map.put("secret",myProperties.getSecret());
        map.put("number",myProperties.getNumber());
        map.put("pname",myProperties.getName());
        map.put("desc",myProperties.getDesc());
        return map;
    }

    @RequestMapping("/getUser/{id}/{name}")
    public User getUser(@PathVariable int id,@PathVariable String name){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/register/{name}",method = RequestMethod.GET)
    @ResponseBody
    public String register(@PathVariable String name, HttpServletRequest request){
        String ip=request.getRemoteHost();

        return userService.register(name,ip);
    }

}
