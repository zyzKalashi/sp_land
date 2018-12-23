package com.kailash.land.common.enums;

public enum RoleEnum {
	SUPERADMIN(1, "超级管理员"), AREAADMIN(2, "区域管理员"), TOWNADMIN(3, "乡镇管理员"), COMMON(4, "普通用户");
	private int roleId;

	private String name;

	private RoleEnum(int roleId, String name) {
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
