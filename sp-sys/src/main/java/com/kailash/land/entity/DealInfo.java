package com.kailash.land.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class DealInfo extends BaseEntity implements Serializable {
	private String dealNum;

	private String dealName;

	private String dealAddress;
	// 转出方
	private String output;
	// 权证编号
	private String warrantNum;
	// 面积（数量）
	private Integer areaNum;
	// 涉及农户数
	private Integer famerNum;
	// 是否存在他项权利人
	private Integer otherRightFlag;
	// 原承包租赁期
	private String oldRentDate;
	// 地上物情况
	private String upThings;
	// 交通情况
	private String traffic;
	// 是否属再次转让
	private Integer againFlag;
	// 流转承包用途
	private String rentUse;
	// 原承包/出租人是否同意
	private Integer agreeFlag;
	// 前次转出方式
	private String oldOutput;
	// 拟转出方式
	private String hopeOutput;
	// 是否放弃形式优先权
	private Integer giveupRightFlag;
	// 评估机构
	private String assessOrg;
	// 评估基准日
	private String assessDate;
	// 评估值（万元）
	private Double assessValue;
	// 转出方式
	private String outputWay;
	// 拟转出期限
	private String hopeOutputDate;
	// 权属类型
	private Integer rightKind;
	//
	private String rightPicUrl;

}
