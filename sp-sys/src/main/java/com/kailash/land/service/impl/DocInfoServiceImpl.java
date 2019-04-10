package com.kailash.land.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.entity.DocInfo;
import com.kailash.land.mapper.DocInfoMapper;
import com.kailash.land.service.DocInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Mht
 * @since 2019-04-05
 */
@Service
public class DocInfoServiceImpl extends ServiceImpl<DocInfoMapper, DocInfo> implements DocInfoService {
	@Autowired
	private DocInfoMapper docMapper;

	@Override
	public PageInfo<DocInfo> selectNoticePage(DocInfo doc) {
		PageHelper.startPage(doc.getPageNo(), doc.getPageSize());
		List<DocInfo> docs = this.docMapper.selectDocInfo(doc);
		return new PageInfo<>(docs);
	}

}
