package com.kailash.land.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.kailash.land.service.DealService;



public class DealController {
	@Autowired
	private DealService dealService;
	
	public static void main (String[] args) {
		
		var x = 1233;
		
		System.out.println(x);
	}
}
