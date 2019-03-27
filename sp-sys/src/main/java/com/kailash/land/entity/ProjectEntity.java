package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.kailash.land.filter.ProjectFiter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class ProjectEntity extends Model<ProjectEntity> implements Serializable {

	private Integer pkid;

	private Date createDate;
	
	private Integer createUser;
	
	private String updateDate;
	
	private Integer updateUser;
	
	private Integer projectStatus;

	private String projectName;

	private String projectNum;

	private String projectAddress;

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

	public ProjectEntity(ProjectFiter filter) {
		this.projectStatus = filter.getProjectStatus();
		this.projectName = filter.getProjectName();
		this.projectNum = filter.getProjectNum();
		this.projectAddress = filter.getProjectAddress();
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

	@Override
	protected Serializable pkVal() {
		return pkid;
	}

}