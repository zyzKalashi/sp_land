package com.kailash.land.common.annotation;

import java.lang.annotation.*;

/**
 * 
 * 自定义日志注解    
 * 		title:模块名称，例如：系统管理-用户管理; 
 * 		action:功能名称，例如：添加用户
 * 		isSaveRequestData:是否保存param参数,默认保存。
 * @ClassName: Log.java
 * @Description: 该类的功能描述
 *
 * @author: boshao
 * @date: 2018年5月9日 下午6:43:08 
 *
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	
	String title() default "";
	
	String action() default "";

	boolean isSaveRequestData() default true;
}
