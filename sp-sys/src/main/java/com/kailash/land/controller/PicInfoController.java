package com.kailash.land.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.kailash.land.entity.PicInfo;
import com.kailash.land.service.PicInfoService;
import com.kailash.land.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


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
public class PicInfoController {
    @Autowired
    private PicInfoService picService;
    
    @ResponseBody
    @RequestMapping("/picList")
    public Result listActivePic(Integer picType){
        EntityWrapper<PicInfo> ewPic = new EntityWrapper<>();
        ewPic.eq("pic_status","1");
        ewPic.orderBy("pic_order");
        ewPic.setEntity(new PicInfo(){
            {
                this.setPicType(picType);
            }
        });
        List<PicInfo> picInfos = picService.selectList(ewPic);
        return Result.ok().put("data",picInfos);
    }
    
    @ResponseBody
    @RequestMapping("/add_pic")
    public Result add_pic(PicInfo pic){
        try {
            boolean zt = picService.insert(pic);
            if(!zt){
                return Result.error("保存失败");
            }
        } catch (Exception e){
            e.printStackTrace();
            return Result.error("保存失败");
        }
        return Result.ok();
    }
    
    @ResponseBody
    @RequestMapping("/modify_pic")
    public Result modify_pic(PicInfo pic){
        if(ObjectUtils.isEmpty(pic.getPicId())){
            return Result.error("参数错误");
        }
        
        try{
            EntityWrapper<PicInfo> ewPic = new EntityWrapper<>();
            ewPic.setEntity(new PicInfo());
            ewPic.eq("pkid",pic.getPicId());
            boolean zt = picService.update(pic, ewPic);
            if(!zt){
                return Result.error("保存失败");
            }
        } catch (Exception e){
            e.printStackTrace();
            return Result.error("保存失败");
        }
        return Result.ok();
    }
}
