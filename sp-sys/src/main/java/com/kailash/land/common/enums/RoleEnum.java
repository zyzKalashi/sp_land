package com.kailash.land.common.enums;

public enum RoleEnum {
	SUPERADMIN(1,"超级管理员"),COMMON(2,"普通客户");
	
	private int roleId;
	
	private String name;
	
	private RoleEnum(int roleId, String name){
		this.roleId = roleId;
		this.name = name;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
