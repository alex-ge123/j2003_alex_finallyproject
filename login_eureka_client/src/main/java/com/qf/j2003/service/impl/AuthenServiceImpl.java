package com.qf.j2003.service.impl;

import com.qf.j2003.service.AuthenService;
import com.qf.j2003.utils.EncryptUtil;
import org.springframework.stereotype.Service;

/**
  * Description 令牌处理
  * @author sunQuanxi
  * @date 2020/10/15 16:37
  */
@Service
public class AuthenServiceImpl implements AuthenService {
    /**
      * Description: 创建令牌
      * @param uuid 请求ID
      * @return token 令牌
      */
    @Override
    public String createToken(String uuid) {
        String token = EncryptUtil.AESencode("token", uuid);
        return token;
    }

    @Override
    public Boolean checkToken(String token) {
        return null;
    }
}
