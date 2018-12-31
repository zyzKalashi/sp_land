package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

import com.kailash.land.filter.DealFiter;

@SuppressWarnings("serial")
public class DealAround extends BaseEntity implements Serializable {

	private Integer dealInfoId;

	private String areaName;

	private Double area;

	private String east;

	private String south;

	private Date west;

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

	public Integer getDealInfoId() {
		return dealInfoId;
	}

	public void setDealInfoId(Integer dealInfoId) {
		this.dealInfoId = dealInfoId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName == null ? null : areaName.trim();
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getEast() {
		return east;
	}

	public void setEast(String east) {
		this.east = east == null ? null : east.trim();
	}

	public String getSouth() {
		return south;
	}

	public void setSouth(String south) {
		this.south = south == null ? null : south.trim();
	}

	public Date getWest() {
		return west;
	}

	public void setWest(Date west) {
		this.west = west;
	}

	public String getNorth() {
		return north;
	}

	public void setNorth(String north) {
		this.north = north == null ? null : north.trim();
	}

	public Double getShowpreice() {
		return showpreice;
	}

	public void setShowpreice(Double showpreice) {
		this.showpreice = showpreice;
	}

	public String getPayway() {
		return payway;
	}

	public void setPayway(String payway) {
		this.payway = payway == null ? null : payway.trim();
	}

	public String getPaylimit() {
		return paylimit;
	}

	public void setPaylimit(String paylimit) {
		this.paylimit = paylimit == null ? null : paylimit.trim();
	}

	public String getOtherpay() {
		return otherpay;
	}

	public void setOtherpay(String otherpay) {
		this.otherpay = otherpay == null ? null : otherpay.trim();
	}

	public String getShouldhave() {
		return shouldhave;
	}

	public void setShouldhave(String shouldhave) {
		this.shouldhave = shouldhave == null ? null : shouldhave.trim();
	}

	public String getOverdue() {
		return overdue;
	}

	public void setOverdue(String overdue) {
		this.overdue = overdue == null ? null : overdue.trim();
	}

	public String getSupplement() {
		return supplement;
	}

	public void setSupplement(String supplement) {
		this.supplement = supplement == null ? null : supplement.trim();
	}

	public String getIdcardpic() {
		return idcardpic;
	}

	public void setIdcardpic(String idcardpic) {
		this.idcardpic = idcardpic == null ? null : idcardpic.trim();
	}

	public String getRightpic() {
		return rightpic;
	}

	public void setRightpic(String rightpic) {
		this.rightpic = rightpic == null ? null : rightpic.trim();
	}

	public String getDealpic() {
		return dealpic;
	}

	public void setDealpic(String dealpic) {
		this.dealpic = dealpic == null ? null : dealpic.trim();
	}
}