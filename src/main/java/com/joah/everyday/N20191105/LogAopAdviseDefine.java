package com.joah.everyday.N20191105;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 某个服务下的方法的调用需要有 log: 记录调用的参数以及返回结果.
 *
 * 当方法调用出异常时, 有特殊处理, 例如打印异常 log, 报警等.
 */
@Aspect
@Component
public class LogAopAdviseDefine {

}
