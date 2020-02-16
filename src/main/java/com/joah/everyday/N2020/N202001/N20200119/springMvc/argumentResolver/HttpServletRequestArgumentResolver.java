package com.joah.everyday.N2020.N202001.N20200119.springMvc.argumentResolver;

import com.joah.everyday.N2020.N202001.N20200119.springMvc.annotation.CustomService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author Joah
 * @time 2020/1/20 17:03
 */
@CustomService("httpServletRequestArgumentResolver")
public class HttpServletRequestArgumentResolver implements ArgumentResolver{

    @Override
    public boolean support(Class<?> type, int paramIndex, Method method) {

        return ServletRequest.class.isAssignableFrom(type);
    }

    @Override
    public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int paramIndex, Method method) {

        return request;
    }
}
