package com.qianfeng.j2003.config;

import com.qianfeng.j2003.util.SingleTonRedisUtils;
import com.qianfeng.j2003.util.UnionSerializerConvertor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

/**
 * Created by ZAM-PC on 2020/9/17.
 */
@Configuration
public class RedisConfig {
    @Bean
    public SingleTonRedisUtils singleTonRedisUtils(@Qualifier("jedis") Jedis jedis){
        SingleTonRedisUtils singleTonRedisUtils = new SingleTonRedisUtils(jedis);
        return singleTonRedisUtils;
    }

    @Bean(name="jedis")
    public Jedis jedis(){
        Jedis jedis = new Jedis("localhost", 6379);
        return jedis;
    }
    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        //        配置redis的连接工厂
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        //        key值序列化
        redisTemplate.setKeySerializer(new UnionSerializerConvertor());
//        value值序列化
        redisTemplate.setValueSerializer(new UnionSerializerConvertor());
        return redisTemplate;

    }
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }
}
