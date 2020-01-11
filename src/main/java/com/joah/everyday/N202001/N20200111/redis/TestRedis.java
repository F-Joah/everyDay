package com.joah.everyday.N202001.N20200111.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private RedisHelperImpl redisHelper;

    @Test
    public void test() throws Exception{
        // 基本写法
        Author user=new Author();
        user.setName("Neo");
        user.setInfo("不会打篮球的程序不是好男人");
        redisHelper.valuePut("aaa",user);
        System.out.println(redisHelper.getValue("aaa"));
    }
}
