package com.kailash.land.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.kailash.land.entity.Demand;

@Mapper
public interface DemandMapper extends BaseMapper<Demand> {

	Page<Map<String, Object>> querySimpleList(@Param("dem") Demand filter);

}