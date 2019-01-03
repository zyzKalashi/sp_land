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
import com.kailash.land.entity.MenuEntity;
import com.kailash.land.entity.Users;
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


        } catch (AuthenticationException e) {
            return Result.error("用户名/密码不正确");
        }
        return Result.ok(map);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Users user) {
        logout();
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String host(Users user) {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/loginInfo", method = RequestMethod.POST)
    public Result loginInfo() {
        Users user = getUser();
        return Result.ok().put("user", user);
    }

}
