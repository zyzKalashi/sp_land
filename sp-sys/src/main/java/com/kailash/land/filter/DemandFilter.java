package com.kailash.land.filter;


import java.util.List;

import lombok.Data;

@Data
public class DemandFilter {

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
	
	
	private List<Integer> demandKindList;
}
