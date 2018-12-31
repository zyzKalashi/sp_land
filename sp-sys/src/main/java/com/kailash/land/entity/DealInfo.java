package com.kailash.land.entity;

import java.io.Serializable;

import com.kailash.land.filter.DealFiter;

@SuppressWarnings("serial")
public class DealInfo extends BaseEntity implements Serializable {
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

	public DealInfo() {
	}

	public DealInfo(DealFiter filter) {
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

	public Integer getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName == null ? null : dealName.trim();
	}

	public String getDealNum() {
		return dealNum;
	}

	public void setDealNum(String dealNum) {
		this.dealNum = dealNum == null ? null : dealNum.trim();
	}

	public String getDealAddress() {
		return dealAddress;
	}

	public void setDealAddress(String dealAddress) {
		this.dealAddress = dealAddress == null ? null : dealAddress.trim();
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output == null ? null : output.trim();
	}

	public Integer getRightKind() {
		return rightKind;
	}

	public void setRightKind(Integer rightKind) {
		this.rightKind = rightKind;
	}

	public String getWarrantNum() {
		return warrantNum;
	}

	public void setWarrantNum(String warrantNum) {
		this.warrantNum = warrantNum == null ? null : warrantNum.trim();
	}

	public Double getAreaNum() {
		return areaNum;
	}

	public void setAreaNum(Double areaNum) {
		this.areaNum = areaNum;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName == null ? null : personName.trim();
	}

	public Integer getOtherRightFlag() {
		return otherRightFlag;
	}

	public void setOtherRightFlag(Integer otherRightFlag) {
		this.otherRightFlag = otherRightFlag;
	}

	public String getOtherRightName() {
		return otherRightName;
	}

	public void setOtherRightName(String otherRightName) {
		this.otherRightName = otherRightName == null ? null : otherRightName.trim();
	}

	public String getOtherRightContext() {
		return otherRightContext;
	}

	public void setOtherRightContext(String otherRightContext) {
		this.otherRightContext = otherRightContext == null ? null : otherRightContext.trim();
	}

	public Integer getFamerNum() {
		return famerNum;
	}

	public void setFamerNum(Integer famerNum) {
		this.famerNum = famerNum;
	}

	public String getOldRentDate() {
		return oldRentDate;
	}

	public void setOldRentDate(String oldRentDate) {
		this.oldRentDate = oldRentDate == null ? null : oldRentDate.trim();
	}

	public String getLandLevel() {
		return landLevel;
	}

	public void setLandLevel(String landLevel) {
		this.landLevel = landLevel == null ? null : landLevel.trim();
	}

	public String getUpThings() {
		return upThings;
	}

	public void setUpThings(String upThings) {
		this.upThings = upThings == null ? null : upThings.trim();
	}

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic == null ? null : traffic.trim();
	}

	public Integer getAgainFlag() {
		return againFlag;
	}

	public void setAgainFlag(Integer againFlag) {
		this.againFlag = againFlag;
	}

	public String getRentUse() {
		return rentUse;
	}

	public void setRentUse(String rentUse) {
		this.rentUse = rentUse == null ? null : rentUse.trim();
	}

	public Integer getAgreeFlag() {
		return agreeFlag;
	}

	public void setAgreeFlag(Integer agreeFlag) {
		this.agreeFlag = agreeFlag;
	}

	public String getOldOutput() {
		return oldOutput;
	}

	public void setOldOutput(String oldOutput) {
		this.oldOutput = oldOutput == null ? null : oldOutput.trim();
	}

	public String getHopeOutput() {
		return hopeOutput;
	}

	public void setHopeOutput(String hopeOutput) {
		this.hopeOutput = hopeOutput == null ? null : hopeOutput.trim();
	}

	public Integer getGiveupRightFlag() {
		return giveupRightFlag;
	}

	public void setGiveupRightFlag(Integer giveupRightFlag) {
		this.giveupRightFlag = giveupRightFlag;
	}

	public String getAssessOrg() {
		return assessOrg;
	}

	public void setAssessOrg(String assessOrg) {
		this.assessOrg = assessOrg == null ? null : assessOrg.trim();
	}

	public String getAssessDate() {
		return assessDate;
	}

	public void setAssessDate(String assessDate) {
		this.assessDate = assessDate == null ? null : assessDate.trim();
	}

	public Double getAssessValue() {
		return assessValue;
	}

	public void setAssessValue(Double assessValue) {
		this.assessValue = assessValue;
	}

	public String getOutputWay() {
		return outputWay;
	}

	public void setOutputWay(String outputWay) {
		this.outputWay = outputWay == null ? null : outputWay.trim();
	}

	public String getHopeOutputDate() {
		return hopeOutputDate;
	}

	public void setHopeOutputDate(String hopeOutputDate) {
		this.hopeOutputDate = hopeOutputDate == null ? null : hopeOutputDate.trim();
	}

}