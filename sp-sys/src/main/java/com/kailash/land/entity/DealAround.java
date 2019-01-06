package com.kailash.land.entity;

import java.io.Serializable;

import com.kailash.land.filter.DealFiter;

import lombok.Data;
@Data
@SuppressWarnings("serial")
public class DealAround extends BaseEntity implements Serializable {

	private Integer dealInfoId;

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

	public DealAround() {
	}

	public DealAround(DealFiter filter) {
		this.dealInfoId = filter.getDealInfoId();
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
		this.dealpic = filter.getDealpic();
	}


}