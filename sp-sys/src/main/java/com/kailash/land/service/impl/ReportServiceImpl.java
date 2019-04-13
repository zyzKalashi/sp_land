package com.kailash.land.service.impl;

import com.kailash.land.entity.ReportValue;
import com.kailash.land.mapper.ReportMapper;
import com.kailash.land.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;
    
    public Map<String, Object> gerneralCompreChartsData(ReportValue report){
        Map<String, Object> result = new HashMap<>();
        List<ReportValue> datas = reportMapper.getCompreChartData(report);
        
        result.put("data",datas);
        return result;
    }
}
