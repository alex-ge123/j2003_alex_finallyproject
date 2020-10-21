package com.qf.j2003.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // Environment 获取当前程序的工作环境
    @Bean
    public Docket docket(Environment environment){

        // 设置要显示的 swagger 的环境
        Profiles profiles = Profiles.of("dev","test");

        // 通过environment.acceptsProfiles（） 判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(myApiInfo())
                .enable(flag)
                .select()
                // any() : 扫描全部
                // none() : 全部都不扫描
                // basePackage("") : 扫描指定的包
                // withClassAnnotation() : 扫描带指定注解的类
                // withMethodAnnotation() : 扫描带指定注解的方法
                .apis(RequestHandlerSelectors.any())
                // 指定过滤什么路径
                // .paths(PathSelectors.ant("/order/**"))
                .build();
    }

    // 配置 swagger 信息 = API INFO
    private ApiInfo myApiInfo(){
        Contact contac = new Contact("Leen", "", "1523848010@qq.com") ;
        return new ApiInfo("Leen's APi Documentation"
                , "严以律己，宽以待人"
                , "v1.2"
                , "urn:tos"
                , contac
                , "Apache 2.0"
                , "http://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList());

    }


}