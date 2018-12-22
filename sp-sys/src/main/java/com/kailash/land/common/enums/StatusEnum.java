package com.kailash.land.common.enums;

public enum StatusEnum {
	
	CRM_NORMAL(0,"正常"),CRM_DISABLED(1,"禁用"),
	
	USER_NORMAL(0,"正常"),USER_DISABLED(1,"禁用"),USER_DEL(2,"删除"),AUDIT(3,"待审核");
	
	private Integer id;
	
	private String name;

	private StatusEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
