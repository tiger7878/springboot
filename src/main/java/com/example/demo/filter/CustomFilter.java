package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * 过滤器，过滤所有请求，排除静态资源和druid（好像没效果）
 * @author: monkey
 * @date: 2018/9/4 22:18
 */
@WebFilter(urlPatterns = "/*",
        initParams = {@WebInitParam(name = "exclusions",
                        value ="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*" )})
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=======init filter=================");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("========================do filter======================");
        filterChain.doFilter(servletRequest,servletResponse);//放行
    }

    @Override
    public void destroy() {
        System.out.println("=======destroy filter=================");
    }
}
