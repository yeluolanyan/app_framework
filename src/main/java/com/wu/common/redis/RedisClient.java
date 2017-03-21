package com.wu.common.redis;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;


public class RedisClient {
    private RedisTemplate<String, Object> redisTemplate;

    public final Lock lock;
    public final Queue queue;

    public RedisClient(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
        this.lock = new Lock(redisTemplate);
        this.queue = new Queue(this, redisTemplate);
    }

    public void putString(String key, String value) {
        putObject(key, value);
    }

    /**
     * @param timeout 单位：秒
     */
    public void putString(String key, String value, long timeout) {
        putString(key, value);
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public String getString(String key) {
        Object obj = getObject(key);
        if(obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void delete(String... keys) {
        for(String key : keys) {
            if(key == null) continue;
            redisTemplate.delete(key);
        }
    }

    public Object getObject(String key){
        return redisTemplate.opsForValue().get(key);
    }
    public void putObject(String key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }
}
