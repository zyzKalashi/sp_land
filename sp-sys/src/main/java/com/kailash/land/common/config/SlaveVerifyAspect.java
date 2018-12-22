package com.kailash.land.common.config;

import java.lang.reflect.Method;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import com.kailash.land.common.annotation.SlaveVerify;

@Aspect
@Configuration
public class SlaveVerifyAspect {
	@Pointcut("@annotation(com.kailash.land.common.annotation.SlaveVerify)")
	public void slaveVerify(){}
	
	@SuppressWarnings("unchecked")
	@Before("slaveVerify()")
    public void dobefore(JoinPoint joinPoint){
		Object[] a = joinPoint.getArgs();
		Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        SlaveVerify s = method.getAnnotation(SlaveVerify.class);
		for (Object o : a) {
			if (o instanceof Map) {
				Map<String,Object> map = (Map<String,Object>)o;
				slaveVerify(map,s.value());
			}
		}
    }
	
	protected void slaveVerify(Map<String,Object> map, boolean isGetUserIds){
		if (isGetUserIds) {
			// TODO 想要使用的话必须把userIds的查询写出来，暂时不支持
			map.put("userIds", "");
		} else {
			/*if (ShiroUtils.getRoleId() == RoleEnum.OPERATE.getRoleId()) {
				map.put("operateId", ShiroUtils.getUserId());
			} else if (ShiroUtils.getRoleId() == RoleEnum.AGENT.getRoleId()){
				map.put("parentId", ShiroUtils.getUserId());
			}*/
		}
		
	}
	
}