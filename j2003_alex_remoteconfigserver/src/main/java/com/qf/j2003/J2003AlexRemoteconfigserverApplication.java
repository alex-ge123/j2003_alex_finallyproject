package com.qf.j2003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class J2003AlexRemoteconfigserverApplication {

  public static void main(String[] args) {
    SpringApplication.run(J2003AlexRemoteconfigserverApplication.class, args);
  }
}
