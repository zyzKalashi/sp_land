package com.kailash.land.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.NoticeInfo;
import com.kailash.land.service.NoticeInfoService;
import com.kailash.land.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.*;

@RestController
@RequestMapping(value = "notice")
public class NoticeController extends AbstractController {
	@Autowired
	private NoticeInfoService noticeInfoService;

//	@RequestMapping(value = "notice_add", method = RequestMethod.POST)
//	public Result noticeAdd(NoticeInfo noticeInfo) {
//		try {
//			noticeInfo.setCreateUser(getUserId());
//			noticeInfo.setUpdateUser(getUserId());
//			noticeInfo.setCreateDate(DateUtils.parse(noticeInfo.getCreateDateStr(), "yyyy年MM月dd日"));
//			noticeInfoService.instertNoticeInfo(noticeInfo);
//			Map m = new HashMap();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return Result.error();
//		}
//		return Result.ok();
//	}

	@RequestMapping(value = "noticeSearch", method = RequestMethod.POST)
	public Result noticeSearch(NoticeInfo notice) {
		PageInfo<NoticeInfo> pageInfo = this.noticeInfoService.selectNoticePage(notice);
		return Result.ok().put("pageInfo", pageInfo);
	}

	@RequestMapping(value = "getNoticesKinds", method = RequestMethod.GET)
	public Result getNoticesKinds() {
		Map<String, Object> returnMap = new HashMap<>();

		Map<String, String> kinds = new HashMap<>();
		kinds.put("1", "新闻");
		kinds.put("2", "政策");
		kinds.put("3", "法规");
		kinds.put("4", "公告");
		returnMap.put("kinds", kinds);
		return Result.ok(returnMap);
	}

	@PostMapping(value = "/notice_add")
	@ResponseBody
	public Result add(NoticeInfo notice) {
		notice.setCreateUser(getUserId().intValue());
		notice.setCreateDate(new Date());
		notice.setUpdateUser(getUserId().intValue());
		notice.setUpdateDate(new Date());
		boolean zt = this.noticeInfoService.insert(notice);
		if (zt) {
			return Result.ok();
		}
		return Result.error();
	}

	@PostMapping(value = "/notice_modify")
	@ResponseBody
	public Result modify(NoticeInfo notice) {
		notice.setUpdateUser(getUserId().intValue());
		notice.setUpdateDate(new Date());

		EntityWrapper<NoticeInfo> ewNotice = new EntityWrapper<>();
		ewNotice.setEntity(new NoticeInfo());
		ewNotice.where(" pkid = {0} ", notice.getNoticeId());
		boolean zt = this.noticeInfoService.update(notice, ewNotice);
		if (zt) {
			return Result.ok();
		}
		return Result.error();
	}

	/**
	 * 简单列表
	 * 
	 * @author zyz
	 * @param demand
	 * @return
	 */
	@ResponseBody
	@PostMapping(value = "/simpleList")
	public Result simpleList(NoticeInfo notice) {

		PageInfo<Map<String, Object>> pageInfo = this.noticeInfoService.simpleList(notice);

		return Result.ok().put("pageInfo", pageInfo);
	}

	/**
	 * 通知详情
	 * 
	 * @author zyz
	 * @param demand
	 * @return
	 */
	@ResponseBody
	@PostMapping(value = "/queryDetail")
	public Result noticeDetail(NoticeInfo notice) {
		if (Objects.isNull(notice.getNoticeId())) {
			return Result.error("参数错误");
		}
		notice = this.noticeInfoService.selectById(notice.getNoticeId());
		return Result.ok().put("objData", notice);
	}

	/**
	 * 查询上一个下一个（详情页面用）
	 * 
	 * @author zyz
	 * @param demand
	 * @return
	 */
	@ResponseBody
	@PostMapping(value = "/queryPreNext")
	public Result queryPreNext(NoticeInfo notice) {
		notice.setPageNo(1);
		notice.setPageSize(999999);

		PageInfo<Map<String, Object>> pageInfo = this.noticeInfoService.simpleList(notice);
		int index = 0;
		NoticeInfo preNotice = null, nextNotice = null;

		List<Map<String, Object>> list = pageInfo.getList();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (notice.getNoticeId().equals(Long.parseLong(list.get(i).get("noticeId").toString()))) {
					index = i;
					break;
				}
			}
		}
		if (index > 0) {
			preNotice = this.noticeInfoService.selectById((Serializable) list.get(index - 1).get("noticeId"));
		}
		if (index < list.size() - 1) {
			preNotice = this.noticeInfoService.selectById((Serializable) list.get(index + 1).get("noticeId"));
		}

		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("preNotice", preNotice);
		returnMap.put("nextNotice", nextNotice);

		return Result.ok(returnMap);
	}

	@PostMapping(value = "/simpleImgList")
	public Result simpleImgList(NoticeInfo notice) {

		PageInfo<Map<String, Object>> pageInfo = this.noticeInfoService.simpleImgList(notice);

		return Result.ok().put("pageInfo", pageInfo);
	}
}
