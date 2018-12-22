package com.kailash.land.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;

import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;

public class ExcelUtil {

	/**
	 * 文件下载
	 * 
	 * @author zyz
	 * @param fileName
	 * @param response
	 */
	public static boolean downLoadFile(HttpServletRequest request, HttpServletResponse response, String fileName) {
		InputStream fis = null;
		ServletOutputStream streamOut = null;
		try {
			request.setCharacterEncoding("UTF-8");
			File file = new File(fileName);
			if (!file.exists()) {
				return false;
			}
			fis = new BufferedInputStream(new FileInputStream(file));
			streamOut = response.getOutputStream();
			// fileName = new String(file.getName().getBytes("UTF-8"), "UTF-8");
			fileName = new String(file.getName().getBytes("utf-8"), "ISO8859-1");
			response.reset();
			response.setContentType("application/x-download;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			int bytesRead;
			byte[] buffer = new byte[1024];
			while ((bytesRead = fis.read(buffer, 0, 1024)) > 0) {
				streamOut.write(buffer, 0, bytesRead);
			}
			streamOut.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			IOUtils.closeQuietly(streamOut);
			IOUtils.closeQuietly(fis);
		}
		return true;
	}

	/**
	 * 获取url-excel导出的字段
	 * 
	 * @author zyz
	 * @param userColumns
	 * @return
	 */
	public static List<ExcelExportEntity> createExcelExportEntity(String[] userColumns) {
		List<String> userColumnsList = new ArrayList<>();
		if (userColumns != null && userColumns.length > 0) {
			for (String string : userColumns) {
				userColumnsList.add(string);
			}
		}
		ExcelExportEntity colEntity = null;
		List<ExcelExportEntity> colList = new ArrayList<ExcelExportEntity>();
		if (userColumnsList.contains("mtagname")) {
			colEntity = new ExcelExportEntity("标签", "mtagname", 40);
			colEntity.setWrap(false);
			colList.add(colEntity);
		}
		if (userColumnsList.contains("linkUrl")) {
			colEntity = new ExcelExportEntity("URL", "linkUrl", 80);
			colEntity.setWrap(false);
			colList.add(colEntity);
		}
		if (userColumnsList.contains("filter")) {
			colEntity = new ExcelExportEntity("是否过滤搜索引擎(是、否)", "filter");
			colEntity.setWrap(false);
			colList.add(colEntity);
		}
		if (userColumnsList.contains("urlIdShow")) {
			colEntity = new ExcelExportEntity("url_id", "urlIdShow");
			colEntity.setWrap(false);
			colEntity.setType(10);// 数字
			colList.add(colEntity);
		}
		if (userColumnsList.contains("mtagid")) {
			colEntity = new ExcelExportEntity("tag_id", "mtagid", 20);
			colEntity.setWrap(false);
			colList.add(colEntity);
		}
		if (userColumnsList.contains("urlName")) {
			colEntity = new ExcelExportEntity("URL名称", "urlName");
			colEntity.setWrap(false);
			colList.add(colEntity);
		}
		if (userColumnsList.contains("tradeFirst")) {
			colEntity = new ExcelExportEntity("一级分类", "tradeFirst");
			colEntity.setWrap(false);
			colList.add(colEntity);
		}
		if (userColumnsList.contains("tradeSecond")) {
			colEntity = new ExcelExportEntity("二级分类", "tradeSecond");
			colEntity.setWrap(false);
			colList.add(colEntity);
		}
		return colList;
	}

	/**
	 * 获取url-excel导出(标签)的字段
	 * 
	 * @author zyz
	 * @return
	 */
	public static List<ExcelExportEntity> createExcelExportTagEntity() {
		ExcelExportEntity colEntity = null;
		List<ExcelExportEntity> colList = new ArrayList<ExcelExportEntity>();
		colEntity = new ExcelExportEntity("标签ID", "mtagid", 20);
		colEntity.setWrap(false);
		colList.add(colEntity);
		colEntity = new ExcelExportEntity("标签", "mtagname", 40);
		colEntity.setWrap(false);
		colList.add(colEntity);
		return colList;
	}

	public static List<Map<String, Object>> noRepetitionTag(List<Map<String, Object>> dealList) {
		List<Map<String, Object>> noRepetitionList = new ArrayList<>();

		Map<String, Object> noRepetitionMap = new HashMap<>();
		for (Map<String, Object> map : dealList) {
			noRepetitionMap.put(map.get("mtagid").toString(), map.get("mtagname"));
		}

		Map<String, Object> map;
		Set<String> keySet = noRepetitionMap.keySet();
		for (String key : keySet) {
			map = new HashMap<>();
			map.put("mtagid", key);
			map.put("mtagname", noRepetitionMap.get(key));
			noRepetitionList.add(map);
		}
		return noRepetitionList;
	}

}
