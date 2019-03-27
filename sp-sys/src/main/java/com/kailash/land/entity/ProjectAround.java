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
public class ProjectAround extends Model<ProjectAround> implements Serializable {

	private Integer pkid;

	private Date createDate;

	private Integer createUser;

	private String updateDate;

	private Integer updateUser;

	private Integer projectId;

	private String areaName;

	private Double area;

	private String east;

	private String south;

	private String west;

	private String north;

	private Double showpreice;

	private String payway;

	private String paylimit;

	private String otherpay;

	private String shouldhave;

	private String overdue;

	private String supplement;

	private String idcardpic;

	private String rightpic;

	private String dealpic;

	public ProjectAround(ProjectFiter filter) {
		this.projectId = filter.getProjectId();
		this.areaName = filter.getAreaName();
		this.area = filter.getArea();
		this.east = filter.getEast();
		this.south = filter.getSouth();
		this.west = filter.getWest();
		this.north = filter.getNorth();
		this.showpreice = filter.getShowpreice();
		this.payway = filter.getPayway();
		this.paylimit = filter.getPaylimit();
		this.otherpay = filter.getOtherpay();
		this.shouldhave = filter.getShouldhave();
		this.overdue = filter.getOverdue();
		this.supplement = filter.getSupplement();
		this.idcardpic = filter.getIdcardpic();
		this.rightpic = filter.getRightpic();
		this.dealpic = filter.getProjectpic();
	}

	@Override
	protected Serializable pkVal() {
		return pkid;
	}

}