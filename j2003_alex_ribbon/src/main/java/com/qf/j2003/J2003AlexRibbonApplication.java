package com.qf.j2003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
//@EnableHystrix   //开启熔断服务
@EnableCircuitBreaker  //开启熔断服务
@EnableHystrixDashboard  //开启熔断仪表功能
@ServletComponentScan("com.qf.j2003.filter") //设置servlet组件扫描路径
public class J2003AlexRibbonApplication {

  public static void main(String[] args) {
    SpringApplication.run(J2003AlexRibbonApplication.class, args);
  }
}
