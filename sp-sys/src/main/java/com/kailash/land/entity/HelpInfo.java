package com.kailash.land.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class HelpInfo extends BaseEntity implements Serializable{
	
	private String helpTitle;
	
	private String helpText;
	
	
}
