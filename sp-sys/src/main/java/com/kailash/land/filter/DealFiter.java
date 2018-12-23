package com.kailash.land.filter;

import java.io.Serializable;

import com.kailash.land.entity.DealPerson;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class DealFiter implements Serializable{
	private DealPerson dealPerson;
	
}
