package com.qianfeng.j2003;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.qianfeng.j2003.mapper"})
public class J2003MyteacherApplication {

	public static void main(String[] args) {
		SpringApplication.run(J2003MyteacherApplication.class, args);
	}

}
