package com.joah.everyday.N2020.N202001.N20200119.springMvc.annotation;

import java.lang.annotation.*;

/**
 * @author Joah
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomQualifier {

    String value() default "";
}
