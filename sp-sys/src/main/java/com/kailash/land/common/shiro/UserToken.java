package com.kailash.land.common.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UserToken extends UsernamePasswordToken {

	private static final long serialVersionUID = -5712014289535264665L;

	public UserToken(String userName, char[] password) {
		super(userName, password);
	}
}
