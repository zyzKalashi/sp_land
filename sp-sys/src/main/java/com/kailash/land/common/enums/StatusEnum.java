package com.kailash.land.common.enums;

public enum StatusEnum {

	CRM_NORMAL(0, "正常"), CRM_DISABLED(1, "禁用"),

//	0:正常，1:禁用，2:删除，3：待审核，4：拒绝
	USER_NORMAL(0, "正常"), USER_DISABLED(1, "禁用"), USER_DEL(2, "删除"), AUDIT(3, "待审核"), REFUSE(4, "拒绝"),
	
	COMMON_DEL(0, "删除"), 
	COMMON_NORMAL(1, "正常"), 
	COMMON_AUDIT(2, "待审核"), 
	COMMON_REFUSE(3, "拒绝"), 
	COMMON_FINISH(4, "结束"), 
	COMMON_DISABLED(5, "禁用")
	
	;
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
