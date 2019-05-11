
package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import com.kailash.land.filter.ProjectFiter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("project")
public class Project extends Model<Project> {
	
	private static final long serialVersionUID = 1L;

	@TableId(value = "pkid", type = IdType.AUTO)
	private Long pkid;

	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Date createDate;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer createUser;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Date updateDate;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer updateUser;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String projectNo;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer projectStatus;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String projectName;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String projectAddress;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String outputPersonName;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer projectKind;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer rightKind;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String warrantNum;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Double areaNum;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String personName;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer otherRightFlag;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String otherRightName;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String otherRightContext;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer famerNum;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String landLevel;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String upThings;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String traffic;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer againFlag;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String rentUse;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer agreeFlag;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String oldOutput;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String hopeOutput;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer giveupRightFlag;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String assessOrg;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String assessDate;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Double assessValue;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String outputWay;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String refuseResult;

	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String oldRentDateStart;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String oldRentDateEnd;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String hopeOutputDateStart;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String hopeOutputDateEnd;

	@TableField(value = "audit_date", strategy = FieldStrategy.NOT_NULL)
	private Date auditDate;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer auditUser;

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
		this.oldRentDateStart = filter.getOldRentDateStart();
		this.oldRentDateEnd = filter.getOldRentDateEnd();
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
		this.hopeOutputDateStart = filter.getHopeOutputDateStart();
		this.hopeOutputDateEnd = filter.getHopeOutputDateEnd();
		this.pkid = filter.getProjectId();
		this.projectStatus = filter.getProjectStatus();
		this.refuseResult = filter.getRefuseResult();
	}

	@Override
	protected Serializable pkVal() {
		return pkid;
	}

	public Project(Long projectId, Integer projectStatus) {
		this.pkid = projectId;
		this.projectStatus = projectStatus;
	}

}