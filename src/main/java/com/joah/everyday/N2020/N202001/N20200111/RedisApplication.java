package com.joah.everyday.N2020.N202001.N20200111;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args){
        SpringApplication.run(RedisApplication.class, args);
    }

}
