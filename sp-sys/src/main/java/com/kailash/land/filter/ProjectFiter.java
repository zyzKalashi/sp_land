package com.kailash.land.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectFiter {
	
	// projectPerson
	private String name;
	private Integer sex;
	private Integer townCode;
	private Integer areaCode;
	private Integer infoKind;
	private String mobile;
	private String idCardFrontUrl;
	private String idCardBackUrl;
	private String address;
	
	// project
	private String projectName;
	private Integer projectKind;
	private String projectAddress;
	private String outputPersonName;
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
	private Long projectId;
//	private Integer projectStatus;
//	private String projectNo;
	
	// projectAround
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
	

}
