package com.joah.everyday.N202001.N20200119.springMvc.argumentResolver;

import com.joah.everyday.N202001.N20200119.springMvc.annotation.CustomRequestParam;
import com.joah.everyday.N202001.N20200119.springMvc.annotation.CustomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Joah
 * @time 2020/1/20 17:06
 */
@CustomService("requestParamArgumentResolver")
public class RequestParamArgumentResolver implements ArgumentResolver {

    @Override
    public boolean support(Class<?> type, int paramIndex, Method method) {

        // 获取当前方法的参数
        Annotation[][] an = method.getParameterAnnotations();
        Annotation[] paramAns = an[paramIndex];

        for (Annotation paramAn : paramAns){
            // 判断传进来 paramAn.getClass() 是不是 @CustomRequestParam 类型
            if (CustomRequestParam.class.isAssignableFrom(paramAn.getClass())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int paramIndex, Method method) {

        // 获取当前方法的参数
        Annotation[][] an = method.getParameterAnnotations();
        Annotation[] paramAns = an[paramIndex];

        for (Annotation paramAn : paramAns){
            // 判断传进的 paramAn.getClass() 是不是 @CustomRequestParam 类型
            if (CustomRequestParam.class.isAssignableFrom(paramAn.getClass())){
                CustomRequestParam cr = (CustomRequestParam) paramAn;
                String value = cr.value();

                return request.getParameter(value);
            }
        }
        return null;
    }
}
