package com.kailash.land.filter;

import java.io.Serializable;
import java.util.List;

import com.kailash.land.entity.DealAround;
import com.kailash.land.entity.DealInfo;
import com.kailash.land.entity.DealPerson;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class DealFiter implements Serializable{
	
	private DealPerson dealPerson;
	
	private DealInfo dealInfo;
	
	private List<DealAround> dealAroundList;
	
}
