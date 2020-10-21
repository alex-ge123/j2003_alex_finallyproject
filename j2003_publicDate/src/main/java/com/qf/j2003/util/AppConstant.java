package com.qf.j2003.util;
/**
  * Description 应用常量
  * @author sunQuanxi
  * @date 2020/10/15 17:21
  */
public interface AppConstant {
    String REDIS_TICKET_PREFIX="TICKET:";
    int REDIS_TICKET_ALIVE_TIME = 60;
    boolean ENABLE_DISPOSABLE_TICKET = false;
    String AUTHEN_CENTER_URL = "http://localhost:8088/";
}
