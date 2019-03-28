package com.kailash.land.util;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kailash.land.entity.Users;

/**
 * Shiro工具类
 * 
 */
public class ShiroUtils {

	private static Logger logger = LoggerFactory.getLogger(ShiroUtils.class);
	private final static String X_REQUESTED_WITH_STRING = "X-Requested-With";
	private final static String XML_HTTP_REQUEST_STRING = "XMLHttpRequest";

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	public static Users getUsers() {
		return (Users) SecurityUtils.getSubject().getPrincipal();
	}

	public static int getUserId() {
		return getUsers().getUserId().intValue();
	}

	public static int getRoleId() {
		return getUsers().getRoleId();
	}

	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}

	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}

	public static void logout() {
		SecurityUtils.getSubject().logout();
	}

	public static String getKaptcha(String key) {
		String kaptcha = getSessionAttribute(key).toString();
		getSession().removeAttribute(key);
		return kaptcha;
	}

	public static String getIp() {
		return getSession().getHost();
	}

	// 判断是否包含某权限
	public static boolean isPerm(String perm) {
		return getSubject().isPermitted(perm);
	}

	/**
	 * 获取request对象
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public static boolean isAjax(HttpServletRequest httpServletRequest) {
		String header = httpServletRequest.getHeader(X_REQUESTED_WITH_STRING);
		if (XML_HTTP_REQUEST_STRING.equalsIgnoreCase(header)) {
			logger.debug("当前请求为Ajax请求:{}", httpServletRequest.getRequestURI());
			return Boolean.TRUE;
		}
		logger.debug("当前请求非Ajax请求:{}", httpServletRequest.getRequestURI());
		return Boolean.FALSE;
	}

	public static void out(ServletResponse response, Map<String, Object> resultMap) {
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			out = response.getWriter();
			out.write(JsonUtil.toJson(resultMap).toString());
		} catch (Exception e) {
			logger.info("输出JSON报错:" + e);
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}
	}

}
