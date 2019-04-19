package com.kailash.land.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kailash.land.entity.AreaCode;

@Mapper
public interface AreaCodeMapper extends BaseMapper<AreaCode> {

	List<Map<String, Object>> areaTree(@Param("parentId") int i);

}
