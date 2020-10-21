package com.qf.j2003.service;
/**
  * Description 令牌操作
  * @author sunQuanxi
  * @date 2020/10/15 16:36
  */
public interface AuthenService {
    String createToken(String uuid);
    Boolean checkToken(String token);
}
