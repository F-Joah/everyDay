package com.joah.everyday.N202001.N20200111;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("RedisHelper")
public class RedisHelperImpl<HK, T> implements RedisHelper<HK, T> {

    /**
     * 在构造器中获取redisTemplate实例, key(not hashKey) 默认使用String类型
     */
    private RedisTemplate<String, T> redisTemplate;

    /**
     * 在构造器中通过redisTemplate的工厂方法实例化操作对象
     */
    private HashOperations<String, HK, T> hashOperations;
    private ListOperations<String, T> listOperations;
    private ZSetOperations<String, T> zSetOperations;
    private SetOperations<String, T> setOperations;
    private ValueOperations<String, T> valueOperations;

    @Autowired
    public RedisHelperImpl(RedisTemplate<String, T> redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        this.listOperations = redisTemplate.opsForList();
        this.zSetOperations = redisTemplate.opsForZSet();
        this.setOperations = redisTemplate.opsForSet();
        this.valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void hashPut(String key, HK hashKey, T domain) {
        hashOperations.put(key, hashKey, domain);
    }

    @Override
    public void valuePut(String key, T domain) {
        valueOperations.set(key, domain);
    }

    @Override
    public T getValue(String key) {
        return valueOperations.get(key);
    }

    @Override
    public boolean expirse(String key, long timeOut, TimeUnit timeUnit) {
        return redisTemplate.expire(key, timeOut, timeUnit);
    }
}
