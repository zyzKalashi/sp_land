package com.kailash.land.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kailash.land.common.shiro.UserToken;
import com.kailash.land.common.web.AbstractController;
import com.kailash.land.entity.LoginLog;
import com.kailash.land.entity.MenuEntity;
import com.kailash.land.entity.Users;
import com.kailash.land.service.LoginLogService;
import com.kailash.land.service.MenuService;
import com.kailash.land.util.Result;
import com.kailash.land.util.ShiroUtils;

/**
 * @Author: jinjx
 * @Date: Create in 2018/4/23
 */
@Controller
public class LoginController extends AbstractController {

    @Autowired
    private MenuService menuService;
    
    @Autowired
    private LoginLogService loginLogService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Users user) {
        return "/index";
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin_login(Users user) {
        return "/admin/login";
    }
    
    @RequestMapping(value = "/admin/main", method = RequestMethod.GET)
    public String admin_index() {
        Users user = getUser();
        if(String.valueOf(user.getRoleId()).matches("1|2|3")){
            return "/admin/index";
        } else {
            return "/index";
        }
    }
    
    /**
     * 用户登录
     *
     * @return
     * @author zyz
     */
    @ResponseBody
    @PostMapping(value = "/sysLogin")
    public Result sysLogin(Users user) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            return Result.error("用户名或密码不能为空");
        }
        try {
            Subject subject = ShiroUtils.getSubject();
            UserToken token = new UserToken(user.getUserName(), user.getPassword().toCharArray());
            subject.login(token);
            user = getUser();
            map.put("roleId", user.getRoleId());


            Map<String, Object> menuMap = new HashMap<>();
            menuMap.put("userId", getUserId());
            // 一级列表
            menuMap.put("type", 1);
            List<MenuEntity> menuEntities = menuService.selectMenuListByUserId(menuMap);
            // 二级列表
            menuMap.put("type", 2);
            for (MenuEntity menuEntity : menuEntities) {
                menuMap.put("parentId", menuEntity.getMenuId());
                List<MenuEntity> second = menuService.selectSecondByParentId(menuMap);
                menuEntity.setSeconds(second);
            }
            
            ShiroUtils.setSessionAttribute("menus", menuEntities);
            
            this.loginLogService.insert(new LoginLog(user.getUserId()));

        } catch (AuthenticationException e) {
            return Result.error("用户名/密码不正确");
        }
        return Result.ok(map);
    }

    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Result logoutSystem() {
        try {
            super.logout();
        } catch (Exception e){
            e.printStackTrace();
            return Result.error("退出登陆失败！");
        }
        return Result.ok();
    }
    
    

    @ResponseBody
    @RequestMapping(value = "/loginInfo", method = RequestMethod.GET)
    public Result loginInfo() {
        Users user = getUser();
        return Result.ok().put("user", user);
    }
    
    @ResponseBody
    @RequestMapping(value = "/menuInfo", method = RequestMethod.GET)
    public Result menuInfo() {
        return Result.ok().put("menu", ShiroUtils.getSessionAttribute("menus"));
    }
}
