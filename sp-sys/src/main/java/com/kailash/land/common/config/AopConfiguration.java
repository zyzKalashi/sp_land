package com.kailash.land.common.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

//@Aspect
@Configuration
public class AopConfiguration {
	@Pointcut("execution(* com.kailash.land.controller.*.*(..))")
	public void pointLog(){}
	
	@Before("pointLog()")
    public void dobefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("================================================================================================");
        System.out.println("URL : "+request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("================================================================================================");
    }
	@AfterReturning(returning = "res", pointcut = "pointLog()")
    public void doAfterReturning(Object res) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("RESPONSE : " + res.toString());
    }
}