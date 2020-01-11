package com.joah.everyday.N202001.N20200111.redis;

import java.util.concurrent.TimeUnit;

/**
 * K 指以hash结构操作时 键类型
 * T 为数据实体 应实现序列化接口,并定义serialVersionUID * RedisTemplate
 * 提供了五种数据结构操作类型 hash / list / set / zset / value
 * 方法命名格式为 数据操作类型 + 操作 如 hashPut 指以hash结构(也就是map)想key添加键值对
 */
public interface RedisHelper<HK, T> {
    /**
     * Hash 结构 添加元素
     * @param key
     * @param hashKey
     * @param domain
     */
    void hashPut(String key, HK hashKey, T domain);

    /**
     * 其他结构先空着
     */


    /**
     * 对象的实体类
     * @param key
     * @param domain
     */
    void valuePut(String key, T domain);

    /**
     * 获取对象
     * @param key
     * @return
     */
    T getValue(String key);

    /**
     * 设置过期时间
     * @param key
     * @param timeOut
     * @param timeUnit
     * @return
     */
    boolean expirse(String key, long timeOut, TimeUnit timeUnit);
}
