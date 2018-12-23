package com.kailash.land.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class DealPerson implements Serializable {

	public DealPerson() {

	}

	private String name;

	private Integer sex;

	private String mobile;

	private String idCard;

	private Integer areaCode;

	private Integer townCode;

	private String address;

}
