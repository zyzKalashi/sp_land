package com.kailash.land.service;

import com.kailash.land.entity.ReportValue;

import java.util.Map;

public interface ReportService {
    Map<String, Object> gerneralCompreChartsData(ReportValue report);
}
