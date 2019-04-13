package com.kailash.land.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportValue {
    /*** 查询条件 ***/
    /**
     * 时间范围
     */
    private String timeFrame;
    
    /**
     * 时间粒度
     */
    private String timeGran;
    
    /**
     * 图表类别
     */
    private String chartType;
    
    /**
     * 区域代码
     */
    private String areaCode;
    
    /**
     * 乡镇代码
     */
    private String townCode;
    
    
    /*** 查询结果 ***/
    /**
     * 值
     */
    private String x;
    /**
     * 时间
     */
    private String y;
    /**
     * 类别
     */
    private String type;
}
