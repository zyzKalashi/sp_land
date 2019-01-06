package com.kailash.land.entity;

import java.io.Serializable;

import com.kailash.land.filter.DemandFilter;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class DemandInfo extends BaseEntity implements Serializable{

	public DemandInfo() {
	
	}
	
	public DemandInfo(DemandFilter filter) {
		this.title = filter.getTitle();
		this.province = filter.getProvince();
		this.city = filter.getCity();
		this.town = filter.getTown();
		this.moneyArea = filter.getMoneyArea();
		this.demandNature= filter.getDemandNature();
		this.person = filter.getPerson();
		this.phone = filter.getPhone();
		this.email = filter.getEmail();
		this.detail = filter.getDetail();
	}

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