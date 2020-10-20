package com.qf.j2003.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by jeffrey on 2020/9/10.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/alex/**")
//                .allowedOrigins("http://127.0.0.1:8080")
                .allowCredentials(true)
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS","PATCH","TRACE");
    }
}
