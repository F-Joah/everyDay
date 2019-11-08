package com.joah.everyday.N20191105;

import com.joah.everyday.N20191105.service.NeedLogService;
import com.joah.everyday.N20191105.service.NormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;

@EnableAspectJAutoProxy
@SpringBootApplication
public class LogAop {

    @Autowired
    NeedLogService needLogService;

    @Autowired
    NormalService normalService;

    public static void main(String[] args) {
        SpringApplication.run(LogAop.class,args);
    }

    @PostConstruct
    public void test(){

        needLogService.logMethod("xys");

        try {
            needLogService.exceptionMethod();
        } catch (Exception e) {

        }
        normalService.someMethod();
    }
}
