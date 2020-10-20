package com.qf.j2003.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
  * Description cookie操作工具类
  * @author sunQuanxi
  * @date 2020/10/15 14:31
  */
public class CookieUtil {
    /**
      * Description: cookie写入
      * @param cookieName 名称  value 值 maxAge 有效时间
      */
    public static void setCookie(HttpServletResponse response, String cookieName, String value, int maxAge){
        //新建cookie
        Cookie cookie = new Cookie(cookieName,value);
        //设置有效期
        cookie.setMaxAge(maxAge);
        //设置路径
        cookie.setPath("/");
        //写入响应流
        response.addCookie(cookie);
    }
    /**
      * Description: 读取cookie
      * @param
      * @return
      */
    public static String getCookie(HttpServletRequest request,String cookieName){
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
