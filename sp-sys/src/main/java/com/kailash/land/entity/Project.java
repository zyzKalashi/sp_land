
package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.kailash.land.filter.ProjectFiter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
@TableName("project")
public class Project extends Model<Project> implements Serializable {

	@TableId(value = "pkid", type = IdType.AUTO)
	private Long pkid;
	private Date createDate;
	private Integer createUser;
	private String updateDate;
	private Integer updateUser;
	private String projectNo;
	private Integer projectStatus;
	private String projectName;
	private String projectAddress;
	private String outputPersonName;
	private Integer projectKind;
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

	public Project(ProjectFiter filter) {
		this.projectName = filter.getProjectName();
		this.projectKind = filter.getProjectKind();
		this.projectAddress = filter.getProjectAddress();
		this.outputPersonName = filter.getOutputPersonName();
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
		this.upThings = filter.getUpThings();
		this.traffic = filter.getTraffic();
		this.againFlag = filter.getAgainFlag();
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