package com.joah.everyday.N20191109.timeAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class ExpiredAopAdviseDefine {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("within(com.joah.everyday.N20191109.timeAop.Service.SomeService)")
    public void pointCat(){
    }

    @Around("pointCat()")
    public Object methodInvokeExpiredTime(ProceedingJoinPoint joinPoint)throws Throwable{
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 开始
        Object retVal = joinPoint.proceed();
        stopWatch.stop();
        // 结束

        // 上报监控平台
        reportToMonitorSystem(joinPoint.getSignature().toShortString(), stopWatch.getTotalTimeMillis());

        return retVal;
    }

    private void reportToMonitorSystem(String toShortString, long totalTimeMillis) {

        logger.info("---- 方法 {} invoked, 耗时: {} ms",toShortString, totalTimeMillis);
    }
}
