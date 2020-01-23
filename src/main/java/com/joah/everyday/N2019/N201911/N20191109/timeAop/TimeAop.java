package com.joah.everyday.N2019.N201911.N20191109.timeAop;

import com.joah.everyday.N2019.N201911.N20191109.timeAop.Service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;

/**
 * 为服务中的每个方法调用进行调用耗时记录.
 *
 * 将方法调用的时间戳, 方法名, 调用耗时上报到监控平台
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class TimeAop {
    @Autowired
    SomeService someService;

    public static void main(String[] args) {
        SpringApplication.run(TimeAop.class,args);
    }

    @PostConstruct
    public void test(){
        someService.someMethod();
    }

}
