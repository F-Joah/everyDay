package com.joah.everyday.N201912.N20191225;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClient {
    /**
     * // k-v都是字符串
     */
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;


    public void testStringRedisTemplate() {

        /**
         * stringRedisTemplate.opsForValue().set("msg", "这是redis")
         */
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    @Test
    public void testRedisTemplate() {

        redisTemplate.opsForValue().set("user",new User(1,"zhangsan",18));
        User user = (User) redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }

    public static void main(String[] args) {
        RedisClient redisClient = new RedisClient();
        redisClient.testRedisTemplate();
    }

}