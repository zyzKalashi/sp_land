package com.kailash.land.util;

import java.lang.reflect.Field;

public class BeanUtils {
	public static boolean allfieldIsNUll(Object o) {
		try {
			for (Field field : o.getClass().getDeclaredFields()) {
				field.setAccessible(true);// 把私有属性公有化
				if (field.get(o) != null) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
