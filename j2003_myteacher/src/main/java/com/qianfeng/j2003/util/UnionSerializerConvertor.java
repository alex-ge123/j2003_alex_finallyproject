package com.qianfeng.j2003.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Created by ZAM-PC on 2020/9/19.
 */
//自定义redis序列化和反序列化类
public class UnionSerializerConvertor implements RedisSerializer{
    //创建序列化转换器对象
    Converter<Object,byte[]> serializer = new SerializingConverter();
    Converter<byte[],Object> deserializer = new DeserializingConverter();
    byte[] bytes = new byte[0];

    //序列化方法
    @Override
    public byte[] serialize(Object obj) throws SerializationException {
        if(obj!=null){
            bytes = serializer.convert(obj);
        }
       return bytes;
    }
//反序列化方法
    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if(bytes!=null){
            Object obj = deserializer.convert(bytes);
            return obj;
        }
        return null;
    }
}
