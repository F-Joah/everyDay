package com.joah.everyday.N202001.N20200111.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private RedisHelperImpl redisHelper;

    @PostMapping("/setRedis")
    public void setRedis(
            @RequestBody Author author
    ){

        redisHelper.valuePut(author.getName(),author.getInfo());
    }

    @PostMapping("/getRedis")
    public String getRedis(
            @RequestBody Author author
    ){

        Object value = redisHelper.getValue(author.getName());

        return value.toString();
    }
}
