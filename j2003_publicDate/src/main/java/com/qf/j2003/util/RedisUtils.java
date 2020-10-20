package com.qf.j2003.util;

/**
 * Created by jeffrey on 2020/9/17.
 */
public interface RedisUtils {

    public void hset(String key, String field, String value);
    public String hget(String key, String field);
    public void set(String key, String value);
    public String get(String key);
    public void expire(String key, int seconds);
    public long ttl(String key);


}
