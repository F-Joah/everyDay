package com.joah.everyday.N2020.N202001.N20200119.springMvc.annotation;

import java.lang.annotation.*;

/**
 * @author Joah
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomRequestParam {

    String value() default "";
}
