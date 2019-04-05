package com.kailash.land.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageInfo;
import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.DocInfo;
import com.kailash.land.service.DocInfoService;
import com.kailash.land.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/doc")
public class DocController extends AbstractController {
    @Autowired
    private DocInfoService  docService;
    
    @RequestMapping(value = "docSearch", method = RequestMethod.POST)
    @ResponseBody
    public Result noticeSearch(DocInfo doc) {
        PageInfo<DocInfo> pageInfo = this.docService.selectNoticePage(doc);
        return Result.ok().put("pageInfo", pageInfo);
    }
    
    @RequestMapping(value = "getdocKinds", method = RequestMethod.GET)
    @ResponseBody
    public Result getDocKinds(){
        Map<String, Object> returnMap = new HashMap<>();
        
        Map<String,String> kinds = new HashMap<>();
        kinds.put("1", "帮助中心");
        kinds.put("2", "资料下载");
        returnMap.put("kinds",kinds);
        return Result.ok(returnMap);
    }
    @PostMapping(value = "/doc_add")
    @ResponseBody
    public Result add(DocInfo doc) {
        doc.setCreateUser(getUserId().intValue());
        doc.setCreateDate(new Date());
        doc.setUpdateUser(getUserId().intValue());
        doc.setUpdateDate(new Date());
        
        boolean zt = this.docService.insert(doc);
        if (zt) {
            return Result.ok();
        }
        return Result.error();
    }
    
    @PostMapping(value = "/notice_modify")
    @ResponseBody
    public Result modify(DocInfo doc) {
        doc.setUpdateUser(getUserId().intValue());
        doc.setUpdateDate(new Date());
        
        EntityWrapper<DocInfo> ewDoc = new EntityWrapper<>();
        ewDoc.setEntity(new DocInfo());
        ewDoc.where(" pkid = {0} ", doc.getDocId());
        
        boolean zt = this.docService.update(doc,ewDoc);
        if (zt) {
            return Result.ok();
        }
        return Result.error();
    }
}
