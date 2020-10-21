package com.qianfeng.j2003.util;

import redis.clients.jedis.Jedis;

/**
 * Created by ZAM-PC on 2020/9/17.
 */
public class SingleTonRedisUtils implements RedisUtils {
    private Jedis jedis;
    public SingleTonRedisUtils(Jedis jedis) {
        this.jedis = new Jedis();
    }

    @Override
    public void hset(String key, String field, String value) {
        jedis.hset(key,field,value);
    }

    @Override
    public String hget(String key, String field) {
        String hget = jedis.hget(key, field);
        return hget;
    }

    @Override
    public void set(String key, String value) {

    }

    @Override
    public String get(String key) {
        return null;
    }
}
