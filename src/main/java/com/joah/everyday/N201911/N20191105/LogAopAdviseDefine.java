package com.joah.everyday.N201911.N20191105;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 某个服务下的方法的调用需要有 log: 记录调用的参数以及返回结果.
 *
 * 当方法调用出异常时, 有特殊处理, 例如打印异常 log, 报警等.
 */
@Aspect
@Component
public class LogAopAdviseDefine {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("within(com.joah.everyday.N201911.N20191105.service.NeedLogService)")
    public void pointCut(){

    }

    /**
     * 它在一个符合要求的 joinpoint 方法调用前执行, 打印调用的方法名和调用的参数
     * @param joinPoint
     */
    @Before("pointCut()")
    public void logMethodInvokeParm(JoinPoint joinPoint){
        logger.info("----Before method{} invoke, param :{} ----",joinPoint.getSignature().toShortString(),joinPoint.getArgs());
    }

    /**
     * 这个 advice 会在方法调用成功后打印出方法名还反的参数.
     * @param joinPoint
     * @param retVal
     */
    @AfterReturning(pointcut = "pointCut()", returning = "retVal")
    public void logMethodInvokeResult(JoinPoint joinPoint,Object retVal){
        logger.info("----After method{} invoke, result :{} ----",joinPoint.getSignature().toShortString(),joinPoint.getArgs());
    }

    /**
     * 这个 advice 会在指定的 joinpoint 抛出异常时执行, 打印异常的信息.
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(pointcut = "pointCut()", throwing = "exception")
    public void logMethodInvokeException(JoinPoint joinPoint,Exception exception){
        logger.info("---- method{} invoke, exception :{} ----",joinPoint.getSignature().toShortString(),exception.getMessage());
    }

}
