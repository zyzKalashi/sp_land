package com.kailash.land.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kailash.land.entity.AreaCode;
import com.kailash.land.service.AreaCodeService;
import com.kailash.land.util.Result;

@RestController
@RequestMapping(value = "area")
public class AreaCodeController {

	@Autowired
	private AreaCodeService areaCodeService;

	@ResponseBody
	@PostMapping(value = "/initArea")
	public Result initArea() {
		List<AreaCode> area = this.areaCodeService.initArea();
		return Result.ok().put("area", area);
	}

}
