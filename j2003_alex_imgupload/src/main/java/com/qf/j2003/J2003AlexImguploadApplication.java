package com.qf.j2003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class J2003AlexImguploadApplication {

  public static void main(String[] args) {
    SpringApplication.run(J2003AlexImguploadApplication.class, args);
  }
}
