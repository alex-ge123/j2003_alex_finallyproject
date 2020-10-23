package com.qf.j2003.util;

import redis.clients.jedis.Jedis;

/**
 * Created by henry on 2020/10/19.
 */
public class SingleRedisUtil implements RedisUtil {
    private Jedis jedis;
    public SingleRedisUtil(Jedis jedis){
        this.jedis =jedis;
    }
    @Override
    public void hset(String key, String filed, String value) {
        jedis.hset(key,filed,value);
    }

    @Override
    public String hget(String key, String filesd) {
        return jedis.hget(key,filesd);
    }

    @Override
    public void set(String key, String value) {

    }

    @Override
    public String get(String key, String value) {
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
