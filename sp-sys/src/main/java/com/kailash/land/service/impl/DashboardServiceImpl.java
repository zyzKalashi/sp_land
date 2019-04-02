package com.kailash.land.service.impl;

import com.kailash.land.mapper.ProjectMapper;
import com.kailash.land.mapper.UsersMapper;
import com.kailash.land.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    private UsersMapper usersMapper;
    
    @Autowired
    private ProjectMapper projectMapper;
    
    @Override
    public Map<String, Object> getDashboardData() {
        Map<String,Object> result = new HashMap<>();
        
        String d1 = "0";
        String d2 = "0";
        String d3 = "0";
        String d4 = "0";
        List<Map<String,Object>> series = new ArrayList<>();
        Set<String> category = new LinkedHashSet<>();
        
        // 统计项目信息
        Map<String, String> projectResult = projectMapper.projectStatistics();
        if(null != projectResult){
            if(null != projectResult.get("ALL_PROJECT")){
                d1 = projectResult.get("ALL_PROJECT");
            }
            if(null != projectResult.get("AUDIT_PROJECT")){
                d2 = projectResult.get("AUDIT_PROJECT");
            }
        }
        // 统计会员信息
        Map<String, String> userResult = usersMapper.userStatistics();
        if(null != userResult){
            if(null != userResult.get("ALL_USER")){
                d3 = userResult.get("ALL_USER");
            }
            if(null != userResult.get("NEW_USER")){
                d4 = userResult.get("NEW_USER");
            }
        }
        Map<String, String> detailMap = new HashMap<>();
    
        List<Map<String, String>> projectDetail = projectMapper.projectDetailStatistics();
        if(null != projectDetail){
            for(Map<String, String> row : projectDetail){
                String date = row.get("TDATE");
                String type = row.get("KIND");
                String total = row.get("TOTAL");
            
                if(null != date && null != type){
                    detailMap.put(date + "-" + type, total);
                }
            }
        }
    
        Map<String, String> projectTypes = new HashMap<>();
        projectTypes.put("1","土地承包");
        projectTypes.put("2","林权转让");
        projectTypes.put("3","养殖水面");
        projectTypes.put("4","四荒承包");
    
        for(Map.Entry<String, String> entry : projectTypes.entrySet()){
            series.add(new HashMap<>(){
                {
                    this.put("name",entry.getValue());
                    this.put("type","line");
                    this.put("data", new ArrayList<String>(){
                        {
                            Date date = new Date();
                            Calendar calendar = Calendar.getInstance();
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        
                            for(int i = 0;i < 30;i ++){
                                calendar.setTime(date);
                                calendar.add(Calendar.DATE, -(29 - i));
                                String key = format.format(calendar.getTime()) + "-" + entry.getKey();
                                if(null != detailMap.get(key)){
                                    this.add(detailMap.get(key));
                                } else{
                                    this.add("0");
                                }
                            }
                        }
                    });
                }
            });
        }
    
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0;i < 30; i++){
            calendar.setTime(date);
            calendar.add(Calendar.DATE, -(29 - i));
            category.add(format.format(calendar.getTime()));
        }
    
        result.put("d1", d1);
        result.put("d2", d2);
        result.put("d3", d3);
        result.put("d4", d4);
        result.put("series", series);
        result.put("category", category);
        
        return result;
    }
}
