package com.qianfeng.j2003.util;

/**
 * Created by ZAM-PC on 2020/9/17.
 */
public interface RedisUtils {
    public void hset(String key, String field, String value);
    public String hget(String key, String field);
    public void set(String key, String value);
    public String get(String key);
}
