package com.kailash.land.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class DemandInfo extends BaseEntity implements Serializable{

	private Integer demandStatus;

	private String title;

	private Integer province;

	private Integer city;

	private Integer town;

	private Integer moneyArea;

	private Integer demandNature;

	private String person;

	private String phone;

	private String email;

	private String fileUrl;

	private String detail;

}