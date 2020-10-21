package com.qf.j2003.util;

/**
 * Created by henry on 2020/10/19.
 */
public interface RedisUtil {
    //写入的方法
    public void hset(String key,String filed,String value);
    public String hget(String key,String filesd);
    public void set(String key,String value);
    public  String get(String key,String value);

    public void expire(String key,int seconds);

    public long ttl(String key);}
