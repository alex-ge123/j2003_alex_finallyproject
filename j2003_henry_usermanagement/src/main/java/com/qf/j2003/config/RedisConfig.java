package com.qf.j2003.config;

import com.qf.j2003.util.SingleRedisUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import rx.Single;

/**
 * Created by henry on 2020/10/19.
 */
@Configuration
public class RedisConfig {

    @Bean
    public SingleRedisUtil singleRedisUtil(@Qualifier("jedis") Jedis jedis){
        SingleRedisUtil singleRedisUtil = new SingleRedisUtil(jedis);
        return singleRedisUtil;
    }
@Bean(name = "jedis")
    public Jedis getJedis(){
    Jedis jedis = new Jedis("127.0.0.1", 6379);
    return jedis;
}

}
