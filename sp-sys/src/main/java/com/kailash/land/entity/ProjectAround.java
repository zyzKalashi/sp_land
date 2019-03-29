package com.kailash.land.entity;

import java.io.Serializable;

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
@TableName("project_around")
@SuppressWarnings("serial")
public class ProjectAround extends Model<ProjectAround> {

	@TableId(value = "pkid", type = IdType.AUTO)
	private Long pkid;

	private Long projectId;

	private String areaName;
	private Double area;
	private String east;
	private String south;
	private String west;
	private String north;
	private Double showpreice;
	private String payWay;
	private String payLimit;
	private String otherPay;
	private String shouldHave;
	private String overdue;
	private String supplement;

	public ProjectAround(Long projectId) {
		this.projectId = projectId;
	}

	public ProjectAround(ProjectFiter filter) {
		this.areaName = filter.getAreaName();
		this.area = filter.getArea();
		this.east = filter.getEast();
		this.south = filter.getSouth();
		this.west = filter.getWest();
		this.north = filter.getNorth();
		this.showpreice = filter.getShowpreice();
		this.payWay = filter.getPayWay();
		this.payLimit = filter.getPayLimit();
		this.otherPay = filter.getOtherPay();
		this.shouldHave = filter.getShouldHave();
		this.overdue = filter.getOverdue();
		this.supplement = filter.getSupplement();
	}

	@Override
	protected Serializable pkVal() {
		return pkid;
	}

}