package com.kailash.land.common.web;

import java.util.Map;

import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageHelper;
import com.kailash.land.entity.Users;
import com.kailash.land.util.ShiroUtils;

/**
 * Controller公共组件
 * 
 * @Author dl
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected Users getUser() {
		return ShiroUtils.getUsers();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}

	protected int getRoleId() {
		return getUser().getRoleId();
	}

	protected Session getSession() {
		return ShiroUtils.getSession();
	}

	protected void logout() {
		ShiroUtils.logout();
	}

	/**
	 * 设置page信息 等同PageHelper.startPage(pageNo,pageSize);
	 * 
	 * @param map
	 * @author boshao
	 */
	protected void setPage(Map<String, Object> map) {
		if (map.containsKey("pageNo") && map.containsKey("pageSize")) {
			PageHelper.startPage(Integer.parseInt((String) map.get("pageNo")),
					Integer.parseInt((String) map.get("pageSize")));
		}
		if (map.containsKey("orderBy")) {
			PageHelper.orderBy((String) map.get("orderBy"));
		}

	}

}
