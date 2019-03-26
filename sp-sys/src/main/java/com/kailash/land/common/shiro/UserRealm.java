package com.kailash.land.common.shiro;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.kailash.land.entity.RoleEntity;
import com.kailash.land.entity.Users;
import com.kailash.land.service.MenuService;
import com.kailash.land.service.RoleService;
import com.kailash.land.service.UsersService;
import com.kailash.land.util.ShiroUtils;

/**
 * 认证
 */

public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private UsersService usersService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private MenuService menuService;

	/**
	 * 授权(验证权限时调用)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Users user = (Users) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		int roleId = user.getRoleId();
		RoleEntity roleEntity = roleService.queryObject(roleId);
		if (roleEntity != null) {
			info.addRole(roleEntity.getRoleKey());
		}
		// 防止每次请求都要从库里查一遍权限，这样会造成如果库里增加新数据必须重启项目才能更新。
		// 后期可以考虑加cache，或者加其他策略来解决
		Set<String> perms = new HashSet<>();
		if (ShiroUtils.getSessionAttribute("perms") == null) {
			perms = menuService.selectPermsByRoleId(roleId);
			ShiroUtils.setSessionAttribute("perms", perms);
			info.setStringPermissions(perms);
		} else {
			String a = ShiroUtils.getSessionAttribute("perms").toString();
			perms = new HashSet<>(Arrays.asList(a.substring(1, a.length() - 1).split(",")));
			info.setStringPermissions(perms);
		}
		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		Users user = null;
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		user = usersService.queryByUserName(username);
		// 账号不存在
		if (user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}
		// 密码错误
		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("账号或密码不正确");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}
