package com.qf.j2003.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
  * Description TODO
  * @author sunQuanxi
  * @date 2020/10/16 14:34
  */
@Configuration
public class RpcConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
