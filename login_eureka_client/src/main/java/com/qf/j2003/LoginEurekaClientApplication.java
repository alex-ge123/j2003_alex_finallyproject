package com.qf.j2003;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = "com.qf.j2003.mapper")
public class LoginEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginEurekaClientApplication.class, args);
    }

}
