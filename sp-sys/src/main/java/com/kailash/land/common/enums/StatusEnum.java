package com.kailash.land.common.enums;

public enum StatusEnum {
	
	COMMON_DEL(0, "删除"), 
	COMMON_NORMAL(1, "正常"), 
	COMMON_AUDIT(2, "待审核"), 
	COMMON_REFUSE(3, "拒绝"), 
	COMMON_FINISH(4, "结束"), 
	COMMON_DISABLED(5, "禁用"),
	COMMON_TOFINISH(6, "待结束"),
	COMMON_TOTOWN(7, "待乡镇审核"),
	COMMON_TOAREA(8, "待区域审核")
	
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
