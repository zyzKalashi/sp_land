package com.kailash.land.common.enums;

public enum ProjectKindEnum {
	ALL(0, "全部"), 
	TUDI(1, "土地承包"), 
	LINQUAN(2, "林权转让"), 
	YANGZHI(3, "养殖水面"), 
	SIHUANG(4, "四荒承包"),
	;

	private int value;
	private String label;

	private ProjectKindEnum(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public static String getLabelByValue(int value) {
		for (ProjectKindEnum  projectKind: ProjectKindEnum.values()) {
			if (projectKind.getValue() == value) {
				return projectKind.getLabel();
			}
		}
		return "";
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	

}
