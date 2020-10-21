package com.qf.j2003.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jeffrey on 2020/9/24.
 */
@Configuration
public class RibbonConfig{
    @Bean
    @LoadBalanced
    public RestTemplate  restTemplate(){
        return new RestTemplate();
    }
    //    配置负载均衡策略
    @Bean
    public IRule ribbonRule(){
       // return   new RoundRobinRule();//轮询
   // return    new WeightedResponseTimeRule(); //根据响应时间的权重策略
//        new BestAvailableRule(); //最有并发时间最少
       return new RandomRule();//随即策略
    }
}
