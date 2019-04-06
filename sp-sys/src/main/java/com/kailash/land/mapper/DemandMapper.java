package com.kailash.land.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.kailash.land.entity.Demand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DemandMapper extends BaseMapper<Demand> {
	/**
	 * 后台列表查询
	 * @param demand
	 * @return
	 */
	List<Map<String, Object>> selectDemandInfo(Demand demand);
	
	Page<Map<String, Object>> querySimpleList(@Param("dem") Demand filter);

}