package com.qf.j2003.util;

import redis.clients.jedis.Jedis;

/**
 * Created by jeffrey on 2020/9/17.
 */
public class SingleTonRedisUtil implements RedisUtils{
    private Jedis jedis;
    public   SingleTonRedisUtil(Jedis jedis){
         this.jedis = jedis;
    }
    @Override
    public void hset(String key, String field, String value) {
         jedis.hset(key,field,value);
    }

    @Override
    public String hget(String key, String field) {
        return jedis.hget(key,field);
    }

    @Override
    public void set(String key, String value) {

    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public void expire(String key, int seconds) {

    }

    @Override
    public long ttl(String key) {
        return 0;
    }
}
