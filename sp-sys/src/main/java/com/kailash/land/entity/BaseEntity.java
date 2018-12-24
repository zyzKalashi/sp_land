package com.kailash.land.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class BaseEntity implements Serializable {

	private Integer pkid;

	private String createDate;
	
	private Integer createUser;
	
	private String updateDate;
	
	private Integer updateUser;
}
