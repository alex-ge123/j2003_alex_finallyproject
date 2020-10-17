package com.qf.j2003.config;


import com.qf.j2003.util.SingleTonRedisUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {
    @Bean
    public SingleTonRedisUtil singleTonRedisUtil(@Qualifier("jedis") Jedis jedis){
        SingleTonRedisUtil singleTonRedisUtil = new SingleTonRedisUtil(jedis);
        return singleTonRedisUtil;
    }
    @Bean(name="jedis")
    public Jedis getJedis(){
        Jedis jedis = new Jedis("localhost", 6379);
        return jedis;
    }


}
