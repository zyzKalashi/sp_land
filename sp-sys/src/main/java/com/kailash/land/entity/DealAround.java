package com.kailash.land.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class DealAround extends BaseEntity implements Serializable {

	private Integer dealInfoId;

	private String area_name;
	
	private Double area;
	
	private String east;
	
	private String south;
	
	private String west;
	
	private String north;

}
