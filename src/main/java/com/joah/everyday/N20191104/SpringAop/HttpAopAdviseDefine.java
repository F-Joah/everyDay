package com.joah.everyday.N20191104.SpringAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class HttpAopAdviseDefine {

    /**
     * 定义一个切点,使用，切点表达式函数  来描述对那些 join Point 使用 advise
     */
    @Pointcut("@annotation(com.joah.everyday.N20191104.SpringAop.AuthChecker)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object checkAuth(ProceedingJoinPoint joinPoint)throws Throwable{

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        /**
         * 检查用户的token是否正确
         */
        String token = getUserToken(request);
        if (!"123456".equals(token)){
            return "错误，权限不合法";
        }

        return joinPoint.proceed();
    }

    private String getUserToken(HttpServletRequest request){

        Cookie[] cookies = request.getCookies();
        if (cookies == null)
        {
            return "";
        }

        return null;
    }

}
