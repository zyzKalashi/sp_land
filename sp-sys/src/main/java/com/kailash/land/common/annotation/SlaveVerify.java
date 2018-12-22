package com.kailash.land.common.annotation;

import java.lang.annotation.*;

/**
 * 用户业务权限注解,场景：运营只能看到其下代理商无法看到其他运营下代理商。
 * 只是往Map<>中增加 参数，
 * 如果isGetUserIds为true，map中会增加userIds的key，value为其下所有用户id，只包含代理商和客户两层。map.put("userIds","1,2,3,4");
 * 如果isGetUserIds为false，map中会增加parentId或operateId参数，根据当前用户角色而定。map.put("parentId","1");
 * 使用须知:
 * 		sql中必须拼以userIds、parentId、operateId的条件；
 * 		controller方法中必须有Map类型参数；
 * @ClassName: SlaveVerify.java
 * @Description: 该类的功能描述
 * @author: boshao
 * @date: 2018年5月9日 下午6:44:58 
 *
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SlaveVerify {
	
	/**
	 * isGetUserIds
	 * @return
	 */
	boolean value() default true;
}
