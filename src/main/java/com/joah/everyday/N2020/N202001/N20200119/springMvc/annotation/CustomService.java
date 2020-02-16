package com.joah.everyday.N2020.N202001.N20200119.springMvc.annotation;

import java.lang.annotation.*;

/**
 * @author Joah
 * @time 2020/1/19 11:34
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomService {

    String value() default "";
}
