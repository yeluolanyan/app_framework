package com.wu.common.redis;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

public class Queue {
    private RedisClient redis;
    private RedisTemplate<String, Object> redisTemplate;
    Queue(RedisClient redis, RedisTemplate<String, Object> redisTemplate){
        this.redis = redis;
        this.redisTemplate = redisTemplate;
    }
    public void push(String key, Object value){
        redisTemplate.opsForList().rightPush(key, value);
    }
    public void pushAll(String key, List<Object> values){
        redisTemplate.opsForList().rightPushAll(key, values);
    }
    public Object pop(String key){
        return redisTemplate.opsForList().leftPop(key);
    }
}
