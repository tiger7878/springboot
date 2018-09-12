package com.example.demo.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试支持跨域访问的资源
 *
 * @author: monkey
 * @date: 2018/9/5 21:13
 */
@RestController
@RequestMapping("/api")
@Api(value = "ApiController", description = "测试跨域和swagger的控制器") //用在类上，说明该类的作用
public class ApiController {

    //访问：http://localhost:8011/swagger-ui.html测试 swagger

    //细粒度的跨域支持，写到单个方法上
//    @CrossOrigin(origins = "http://localhost:8080")
    @ApiOperation(value = "查找", notes = "根据ID名查找")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "query")
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Map<String, String> get(@RequestParam Integer id) {
        Map<String, String> map = new HashMap<>();
        map.put("title", "hello world");
        map.put("id", id.toString());
        return map;
    }

    @ApiOperation(value = "查找", notes = "根据用户名查找")
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Map<String, String> post(@RequestParam String name) {
        Map<String, String> map = new HashMap<>();
        map.put("title", "hi world");
        map.put("name", name);
        return map;
    }

    @ApiOperation(value = "查找", notes = "根据姓名查找用户")
    @ApiImplicitParam(name = "name",value = "姓名",required = true,paramType = "path")
    @RequestMapping(value = "/getName/{name}", method = RequestMethod.GET)
    public String getName(@PathVariable String name) {
        return "monkey : " + name;
    }

    //不在Swagger-ui界面显示
    @ApiIgnore
    public String getAddress() {
        return "beijing";
    }

}
