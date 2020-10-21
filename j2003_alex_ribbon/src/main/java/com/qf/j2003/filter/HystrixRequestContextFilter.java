package com.qf.j2003.filter;


import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by jeffrey on 2020/9/24.
 */
@WebFilter("/*")
public class HystrixRequestContextFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HystrixRequestContext.initializeContext();//初始化熔断缓存请求上下文
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
