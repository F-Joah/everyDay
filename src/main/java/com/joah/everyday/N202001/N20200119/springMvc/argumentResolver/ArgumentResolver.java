package com.joah.everyday.N202001.N20200119.springMvc.argumentResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author Joah
 * @time 2020/1/20 16:26
 */
public interface ArgumentResolver {

    /**
     * 判断当前类是继承于 argumentResolver
     * @param type 当前参数注解的类
     * @param paramIndex 参数下标
     * @param method 当前的方法
     * @return
     */
    boolean support(Class<?> type, int paramIndex, Method method);

    /**
     *
     * @param request
     * @param response
     * @param type
     * @param paramIndex
     * @param method
     * @return
     */
    Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int paramIndex, Method method);
}
