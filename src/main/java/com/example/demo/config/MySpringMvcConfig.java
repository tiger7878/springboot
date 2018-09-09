package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义spring mvc的配置
 * @author: monkey
 * @date: 2018/9/1 10:29
 */
@Configuration
public class MySpringMvcConfig extends WebMvcConfigurerAdapter {

    //添加自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor handlerInterceptor=new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
                System.out.println("进入自定义拦截器。。。。。。。。。。。。。。。");
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

            }

            @Override
            public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

            }
        };

        registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");
    }

    //允许跨域支持
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //粗粒度的跨域支持
        //允许从 http://localhost:8080 站点发起的对于/api/下所有方法的跨域访问
//        registry.addMapping("/api/**").allowedOrigins("http://localhost:8080");
    }
}
