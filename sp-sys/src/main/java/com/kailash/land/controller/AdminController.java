package com.kailash.land.controller;


import com.kailash.land.mapper.ProjectMapper;
import com.kailash.land.mapper.UsersMapper;
import com.kailash.land.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	@Autowired
	private UsersMapper usersMapper;
	
	@Autowired
	private ProjectMapper projectMapper;
	
	/**
	 * 仪表盘页面跳转
	 * @return
	 */
	@RequestMapping(value = "/dashbord", method = RequestMethod.GET)
	public ModelAndView toDashBord() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/index");
		return mav;
	}
	
	/**
	 * 获取仪表盘数据
	 * @return
	 */
	@PostMapping(value = "/getDashBordData")
	public Result getDashBordData(){
		Result result = new Result();
		
		String d1 = "0";
		String d2 = "0";
		String d3 = "0";
		String d4 = "0";
		List<Map<String,Object>> series = new ArrayList<>();
		Set<String> category = new LinkedHashSet<>();
		
		try {
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
			
			
		} catch (Exception e){
			e.printStackTrace();
			return Result.error("获取初始化数据失败");
		}
		result.put("d1", d1);
		result.put("d2", d2);
		result.put("d3", d3);
		result.put("d4", d4);
		result.put("series", series);
		result.put("category", category);
		return result;
	}
	
	/**
	 * 用户维护列表页面跳转
	 * @return
	 */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
	public ModelAndView toUserPermit() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/user/userList");
		return mav;
	}
	
	/**
	 * 用户信息修改页面跳转
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/userModify", method = RequestMethod.GET)
	public ModelAndView toUserModify(String userId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.setViewName("admin/user/userModify");
		return mav;
	}
	
	/**
	 * 用户信息审核页面跳转
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/userAudit", method = RequestMethod.GET)
	public ModelAndView toUserAudit(String userId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.setViewName("admin/user/userAudit");
		return mav;
	}
}
