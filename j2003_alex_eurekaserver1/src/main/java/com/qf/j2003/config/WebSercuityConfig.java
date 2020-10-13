package com.qf.j2003.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSercuityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        //忽略掉eureka注册，不然会注册不进去
        httpSecurity.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(httpSecurity);
        httpSecurity.rememberMe();


    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("root").password(new BCryptPasswordEncoder().encode("root")).roles();
//    }

}
