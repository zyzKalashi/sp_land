package com.kailash.land.controller;


import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.ReportValue;
import com.kailash.land.service.ReportService;
import com.kailash.land.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/**
 * <p>
 * 图表 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2019-04-11
 */
@Controller
@RequestMapping("/report")
public class ReportController extends AbstractController {
    @Autowired
    private ReportService reportService;
    
    /**
     * 跳转综合图表
     * @param mav
     * @return
     */
    @RequestMapping("/compreCharts")
    public ModelAndView toCompreCharts(ModelAndView mav){
        mav.setViewName("admin/report/compreCharts");
        return mav;
    }
    
    /**
     * 跳转图文图表
     * @param mav
     * @return
     */
    @RequestMapping("/imageCharts")
    public ModelAndView toImageCharts(ModelAndView mav){
        mav.setViewName("admin/report/imageCharts");
        return mav;
    }
    
    /**
     * 跳转表格图表
     * @param mav
     * @return
     */
    @RequestMapping("/tableCharts")
    public ModelAndView toTableCharts(ModelAndView mav){
        mav.setViewName("admin/report/tableCharts");
        return mav;
    }
    
    /**
     * 获取综合图表数据
     * @param report
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCompreChartsData")
    public Result getCompreChartsData(ReportValue report){
        Map<String, Object> result = reportService.gerneralCompreChartsData(report);
        return Result.ok(result);
    }
}
