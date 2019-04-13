package com.kailash.land.mapper;

import com.kailash.land.entity.ReportValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {
    List<ReportValue> getCompreChartData(ReportValue report);
}
