package com.kailash.land.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kailash.land.entity.DealPerson;

@Mapper
public interface DealPersonMapper {

	DealPerson instert(DealPerson dp);
	
	int update(DealPerson dp);
	
	

}
