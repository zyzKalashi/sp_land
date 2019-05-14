package com.kailash.land.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.common.enums.ProjectKindEnum;
import com.kailash.land.entity.Project;
import com.kailash.land.filter.ProjectFiter;
import com.kailash.land.mapper.ProjectMapper;
import com.kailash.land.service.ProjectService;
import com.kailash.land.util.DateFormatConsts;
import com.kailash.land.util.DateUtils;
import com.kailash.land.util.ShiroUtils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

	@Autowired
	private ProjectMapper projectMapper;

	@Value("${export.excelTempPath}")
	private String excelTempPath;

	@Value("${export.chartExport}")
	private String chartExport;

	@Override
	public PageInfo<Map<String, Object>> selectProjectInfo(ProjectFiter filter) {
		PageHelper.startPage(filter.getPageNo(), filter.getPageSize());
		List<Map<String, Object>> result = this.projectMapper.selectProjectInfo(filter);
		return new PageInfo<>(result);
	}

	@Override
	public PageInfo<Map<String, Object>> simpleList(ProjectFiter filter) {
		PageHelper.startPage(filter.getPageNo(), filter.getPageSize());
		Page<Map<String, Object>> pageList = this.projectMapper.querySimpleList(filter);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(pageList);

		return pageInfo;
	}

	@Override
	public Integer countByAreaCode(Integer id) {
		return this.projectMapper.countByAreaCode(id);
	}

	@Override
	public PageInfo<Map<String, Object>> tableData(ProjectFiter param) {
		PageHelper.startPage(param.getPageNo(), param.getPageSize());
		List<Map<String, Object>> result = this.projectMapper.tableData(param);
		result.forEach(v -> {
			v.put("realName", "是");
			v.put("xColumn", "");
		});
		return new PageInfo<>(result);
	}

	@Override
	public String createExcel(ProjectFiter param) {
		try {
			PageHelper.startPage(1, 999999);
			List<Map<String, Object>> result = this.projectMapper.tableData(param);
			Long totalMoney = 0L;
			// 可以抽取为日期工具类

			File f1 = new File(excelTempPath);
			log.info("file1 = {}, path={}", f1.exists(), excelTempPath);
			File f2 = new File("/WEB-INF/classes/doc/project_table_data_template.xlsx");
			log.info("file2 = {}, path={}", f2.exists(), "/WEB-INF/classes/doc/project_table_data_template.xlsx");
			File f3 = new File("classes/doc/project_table_data_template.xlsx");
			log.info("file3 = {}, path={}", f3.exists(), "classes/doc/project_table_data_template.xlsx");
			File f4 = new File("/classes/doc/project_table_data_template.xlsx");
			log.info("file3 = {}, path={}", f4.exists(), "/classes/doc/project_table_data_template.xlsx");
			
			String fileName = "/表格报表" + DateUtils.format(new Date(), DateFormatConsts.DATE_PATTERN_MO) + ".xlsx";
			TemplateExportParams params = new TemplateExportParams(excelTempPath, true);
			if (result != null && result.size() > 0) {
				for (Map<String, Object> map : result) {
					if (StringUtils.isNotEmpty(map.get("showPreice").toString())) {
						totalMoney += Long.parseLong(map.get("showPreice").toString());
					}
					map.put("projectKind",
							ProjectKindEnum.getLabelByValue(Integer.parseInt(map.get("projectKind").toString())));
					map.put("otherRightFlag", Integer.parseInt(map.get("otherRightFlag").toString()) == 1 ? "是" : "否");
				}
			}

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("nickName", ShiroUtils.getUsers().getNickName());
			map.put("date", DateUtils.format(new Date(), DateFormatConsts.DATE_CHINESE));
			map.put("totalMoney", totalMoney);

			map.put("maplist", result);

			Workbook workbook = ExcelExportUtil.exportExcel(params, map);

			File savefile = new File(chartExport);
			if (!savefile.exists()) {
				savefile.mkdirs();
			}

			FileOutputStream fos = new FileOutputStream(savefile + fileName);
			workbook.write(fos);
			fos.close();
			return chartExport + fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
