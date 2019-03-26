package com.kailash.land.entity;

import java.io.Serializable;

import com.kailash.land.filter.ProjectFiter;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class ProjectEntity extends BaseEntity implements Serializable {
	
	private Integer dealStatus;

	private String dealName;

	private String dealNum;

	private String dealAddress;

	private String output;

	private Integer rightKind;

	private String warrantNum;

	private Double areaNum;

	private String personName;

	private Integer otherRightFlag;

	private String otherRightName;

	private String otherRightContext;

	private Integer famerNum;

	private String oldRentDate;

	private String landLevel;

	private String upThings;

	private String traffic;

	private Integer againFlag;

	private String rentUse;

	private Integer agreeFlag;

	private String oldOutput;

	private String hopeOutput;

	private Integer giveupRightFlag;

	private String assessOrg;

	private String assessDate;

	private Double assessValue;

	private String outputWay;

	private String hopeOutputDate;

	public ProjectEntity() {
	}

	public ProjectEntity(ProjectFiter filter) {
		this.dealStatus = filter.getDealStatus();
		this.dealName = filter.getDealName();
		this.dealNum = filter.getDealNum();
		this.dealAddress = filter.getDealAddress();
		this.output = filter.getOutput();
		this.rightKind = filter.getRightKind();
		this.warrantNum = filter.getWarrantNum();
		this.areaNum = filter.getAreaNum();
		this.personName = filter.getPersonName();
		this.otherRightFlag = filter.getOtherRightFlag();
		this.otherRightName = filter.getOtherRightName();
		this.otherRightContext = filter.getOtherRightContext();
		this.famerNum = filter.getFamerNum();
		this.oldRentDate = filter.getOldRentDate();
		this.landLevel = filter.getLandLevel();
		this.upThings = filter.getLandLevel();
		this.traffic = filter.getTraffic();
		this.againFlag = filter.getAgreeFlag();
		this.rentUse = filter.getRentUse();
		this.agreeFlag = filter.getAgreeFlag();
		this.oldOutput = filter.getOldOutput();
		this.hopeOutput = filter.getHopeOutput();
		this.giveupRightFlag = filter.getGiveupRightFlag();
		this.assessOrg = filter.getAssessOrg();
		this.assessDate = filter.getAssessDate();
		this.assessValue = filter.getAssessValue();
		this.outputWay = filter.getOutputWay();
		this.hopeOutputDate = filter.getHopeOutputDate();
	}

}