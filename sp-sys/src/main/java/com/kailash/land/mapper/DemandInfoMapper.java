package com.kailash.land.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.DemandInfo;

@Mapper
public interface DemandInfoMapper extends BaseMapper<DemandInfo> {
	
	int deleteByPrimaryKey(Integer pkid);

	int insertSelective(DemandInfo record);

	DemandInfo selectByPrimaryKey(Integer pkid);

	int updateByPrimaryKeySelective(DemandInfo record);
}