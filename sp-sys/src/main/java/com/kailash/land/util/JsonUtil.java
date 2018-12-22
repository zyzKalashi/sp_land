package com.kailash.land.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonUtil {
    public static String toJson(Map<String, Object> params) {

        return JSON.toJSONString(params);
    }

    public static String toJson(List<Object> params) {

        return JSON.toJSONString(params);
    }

    public static String toJson(String key, String value) {

        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return null;
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put(key, value);
        return JSON.toJSONString(params);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> fromJson(String json) {
        return JSON.parseObject(json, Map.class);
    }


    /**
     * 去除map中value为"" 和 null 的键值对
     *
     * @param json
     * @return
     * @author zyz
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> fromJson_filterEmpty(String json) {
        Map<String, Object> map = JSON.parseObject(json, Map.class);
        Map<String, Object> returnMap = new HashMap<String, Object>();
        for (String key : map.keySet()) {
            if (StringUtils.isNotEmpty(key) && null != map.get(key) && !map.get(key).toString().equals("")) {
                returnMap.put(key, map.get(key));
            }
        }
        return returnMap;
    }

    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("a", 1);
        params.put("b", "cde");
        List<String> list = new ArrayList<String>();
        list.add("ttt");
        list.add("ddd");
        params.put("c", list);

        String str = toJson(params);
        System.out.println(str);

        Map<String, Object> params2 = fromJson(str);
        System.out.println(params2.toString());
    }
}
