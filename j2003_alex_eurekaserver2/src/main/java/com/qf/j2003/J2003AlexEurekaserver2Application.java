package com.qf.j2003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableEurekaServer
@EnableWebSecurity
public class J2003AlexEurekaserver2Application {

  public static void main(String[] args) {
    SpringApplication.run(J2003AlexEurekaserver2Application.class, args);
  }
}
