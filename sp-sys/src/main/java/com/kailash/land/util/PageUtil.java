package com.kailash.land.util;

import com.github.pagehelper.PageHelper;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: yang
 * @Date: 2018/5/16 16:07
 * @Description:
 */
public class PageUtil {

    /**
     * 设置page信息
     * 等同PageHelper.startPage(pageNo,pageSize);
     * @param map
     * @author boshao
     */
    public static void setPage(Map<String,Object> map){
        if (map.containsKey("pageNo") && map.containsKey("pageSize")) {
            PageHelper.startPage(Integer.parseInt((String) map.get("pageNo")), Integer.parseInt((String) map.get("pageSize")));
        }
        if (map.containsKey("orderBy")) {
            PageHelper.orderBy((String) map.get("orderBy"));
        }

    }
}
