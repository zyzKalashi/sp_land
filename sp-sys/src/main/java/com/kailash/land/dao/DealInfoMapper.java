package com.kailash.land.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kailash.land.entity.DealInfo;

@Mapper
public interface DealInfoMapper {
	DealInfo instert(DealInfo dealInfo);

}
