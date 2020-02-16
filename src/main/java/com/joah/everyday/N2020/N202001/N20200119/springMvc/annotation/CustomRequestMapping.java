package com.joah.everyday.N2020.N202001.N20200119.springMvc.annotation;

import java.lang.annotation.*;

/**
 * @author Joah
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomRequestMapping {

    String value() default "";

}
