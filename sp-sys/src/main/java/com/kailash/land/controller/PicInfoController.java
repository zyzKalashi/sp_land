package com.kailash.land.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.PicInfo;
import com.kailash.land.service.PicInfoService;
import com.kailash.land.util.Result;

/**
 * <p>
 * 图片信息 前端控制器
 * </p>
 *
 * @author Mht
 * @since 2019-04-11
 */
@Controller
@RequestMapping("/picInfo")
public class PicInfoController extends AbstractController {
	@Autowired
	private PicInfoService picService;

	@ResponseBody
	@RequestMapping("/picList")
	public Result simpleList(PicInfo picInfo) {
		PageInfo<Map<String, Object>> pageInfo = this.picService.simpleList(picInfo);
		return Result.ok().put("pageInfo", pageInfo);
	}

	@ResponseBody
	@RequestMapping("/picDetail")
	public Result picDetail(PicInfo pic) {
		EntityWrapper<PicInfo> ewPic = new EntityWrapper<>();
		ewPic.setEntity(pic);
		PicInfo result = picService.selectById(pic);
		return Result.ok().put("data", result);
	}

	@ResponseBody
	@RequestMapping("/add_pic")
	public Result add_pic(PicInfo pic) {
		try {
			pic.setCreateUser(getUserId().intValue());
			pic.setCreateDate(new Date());
			pic.setUpdateUser(getUserId().intValue());
			pic.setUpdateDate(new Date());
			pic.setPicStatus(1);
			boolean zt = picService.insert(pic);
			if (!zt) {
				return Result.error("保存失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("保存失败");
		}
		return Result.ok();
	}

	@ResponseBody
	@RequestMapping("/modify_pic")
	public Result modify_pic(PicInfo pic) {
		if (ObjectUtils.isEmpty(pic.getPicId())) {
			return Result.error("参数错误");
		}

		try {
			pic.setUpdateUser(getUserId().intValue());
			pic.setUpdateDate(new Date());

			EntityWrapper<PicInfo> ewPic = new EntityWrapper<>();
			ewPic.setEntity(new PicInfo());
			ewPic.eq("pkid", pic.getPicId());
			boolean zt = picService.update(pic, ewPic);
			if (!zt) {
				return Result.error("保存失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("保存失败");
		}
		return Result.ok();
	}
}
