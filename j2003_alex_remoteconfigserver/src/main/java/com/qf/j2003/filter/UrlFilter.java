package com.qf.j2003.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Component

public class UrlFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      HttpServletRequest httpServletRequest= (HttpServletRequest)servletRequest;
      HttpServletResponse httpServletResponse= (HttpServletResponse)servletResponse;
        String requestURI = httpServletRequest.getRequestURI();

       //只过滤/acuator/bus-refresh的请求
        if(!requestURI.endsWith("/bus-refresh")){
        filterChain.doFilter(servletRequest,servletResponse);
        return;
        }
        //获取原始的body
        String body = readAsChars(httpServletRequest);
    System.out.println("original body:---------"+body);
       //使用HttpServletRequest包装原始请求达到修改post请求中的body内容目的
        CustometRequestWrapper custometRequestWrapper = new CustometRequestWrapper(httpServletRequest);
        filterChain.doFilter(custometRequestWrapper, servletResponse);

    }
    @Override
    public void destroy() {

    }
    private class  CustometRequestWrapper extends HttpServletRequestWrapper{


        public CustometRequestWrapper(HttpServletRequest request) {
            super(request);
        }
        @Override
        public ServletInputStream getInputStream(){
            byte[] bytes=new byte[0];
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return byteArrayInputStream.read()==-1?true:false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };

        }
    }

    private static String readAsChars(HttpServletRequest httpServletRequest) {
        BufferedReader br =null;
      StringBuilder sb =new StringBuilder("");
        try {
            br =httpServletRequest.getReader();
            String str;
            while((str=br.readLine())!=null){
                sb.append(str);

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
