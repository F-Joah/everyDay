package com.joah.everyday.N202001.N20200119.springMvc.argumentResolver;

import com.joah.everyday.N202001.N20200119.springMvc.annotation.CustomService;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author Joah
 * @time 2020/1/20 17:05
 */
@CustomService("httpServletResponseArgumentResolver")
public class HttpServletResponseArgumentResolver implements ArgumentResolver {
    @Override
    public boolean support(Class<?> type, int paramIndex, Method method) {

        return ServletResponse.class.isAssignableFrom(type);
    }

    @Override
    public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int paramIndex, Method method) {

        return response;
    }
}
