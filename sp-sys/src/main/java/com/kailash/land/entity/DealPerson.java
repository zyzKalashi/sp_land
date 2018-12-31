package com.kailash.land.entity;

import java.io.Serializable;

import com.kailash.land.filter.DealFiter;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class DealPerson extends BaseEntity implements Serializable {


	private Integer dealInfoId;

	private String name;

	private Integer sex;

	private Integer infoKind;

	private String mobile;

	private String idCard;

	private String address;

	public DealPerson() {
	}

	public DealPerson(DealFiter filter) {
		this.name = filter.getName();
		this.sex = filter.getSex();
		this.infoKind = filter.getInfoKind();
		this.mobile = filter.getMobile();
		this.idCard = filter.getIdCard();
		this.address = filter.getAddress();
	}
}
