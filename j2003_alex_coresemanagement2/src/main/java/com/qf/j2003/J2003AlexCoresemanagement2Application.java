package com.qf.j2003;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.qf.j2003.mapper"})
public class J2003AlexCoresemanagement2Application {

  public static void main(String[] args) {
    SpringApplication.run(J2003AlexCoresemanagement2Application.class, args);
  }
}
