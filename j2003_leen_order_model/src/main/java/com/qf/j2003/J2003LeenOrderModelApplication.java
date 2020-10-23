package com.qf.j2003;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.qf.j2003.order.mapper")
public class J2003LeenOrderModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(J2003LeenOrderModelApplication.class, args);
    }

}
