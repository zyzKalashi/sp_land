package com.kailash.land.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class TagInfo extends BaseEntity implements Serializable{
	
	private String tagName;

}
