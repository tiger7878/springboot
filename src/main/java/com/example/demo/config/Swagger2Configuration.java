package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger配置文件
 * @author: monkey
 * @date: 2018/9/12 21:44
 */
@Configuration
@EnableSwagger2
@Profile({"dev","test"}) //指定在开发和测试环境中才启用swagger，生产环境中禁用
public class Swagger2Configuration {

    //重复定义不同的Bean就可以有多个组
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("api")//定义组
                .select()//选择哪些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.web"))//拦截的包路径
//                .paths(any())//所有的接口都拦截
                .paths(regex("/api/.*"))//拦截/api/下的接口路径
                .build()//创建
                .apiInfo(apiInfo());//配置说明，在页面上会显示
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("rest")//定义组
                .select()//选择哪些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.web"))//拦截的包路径
//                .paths(any())//所有的接口都拦截
                .paths(regex("/rest/.*"))//拦截/rest/下的接口路径
                .build()//创建
                .apiInfo(apiInfo());//配置说明，在页面上会显示
    }

    private ApiInfo apiInfo(){
        //很多内容可以注释掉
        return new ApiInfoBuilder()
                .title("金麦子")//标题
                .description("spring boot 全集")
                .termsOfServiceUrl("http://www.jmz168.com")
                .contact(new Contact("monkey","http://www.jmz168.com","1832604220@qq.com"))
                .license("Apache License Version 2.0")// 开源协议
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")// 地址
                .version("1.0")
                .build();
    }

}
