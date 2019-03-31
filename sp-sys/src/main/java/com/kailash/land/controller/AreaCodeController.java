package com.kailash.land.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.service.AreaCodeService;

@RestController
@RequestMapping(value = "project")
public class AreaCodeController {

	@Autowired
	private AreaCodeService areaCodeService;
	
	
	
	

}
