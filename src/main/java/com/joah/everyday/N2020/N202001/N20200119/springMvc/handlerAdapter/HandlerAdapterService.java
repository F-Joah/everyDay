package com.joah.everyday.N2020.N202001.N20200119.springMvc.handlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author Joah
 * @time 2020/1/20 16:11
 */
public interface HandlerAdapterService {

    Object[] handle(HttpServletRequest request, HttpServletResponse response, Method method, Map<String, Object> beans);
}
