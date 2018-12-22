package com.kailash.land.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.land.dao.MenuMapper;
import com.kailash.land.entity.MenuEntity;
import com.kailash.land.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
    /**
     * 根据唯一标识查询对象
     * @param menuId
     * @return
     */
    @Override
    public MenuEntity selectEntityById(Integer menuId) {
        return menuMapper.selectEntityById(menuId);
    }


    @Override
	public List<MenuEntity> list() {
		return menuMapper.list();
	}

    @Override
    public List<MenuEntity> selectListByType(int type) {
        return menuMapper.selectListByType(type);
    }


    @Override
    public List<MenuEntity> selectMenuListByUserId(Map<String, Object> param) {
        return menuMapper.selectMenuListByUserId(param);
    }

    @Override
    public List<MenuEntity> selectSecondByParentId(Map<String, Object> param) {
        return menuMapper.selectSecondByParentId(param);
    }

    @Override
    public Set<String> selectPermsByRoleId(Integer roleId) {
        Set<String> perms = new HashSet<>();
        List<MenuEntity> selects = menuMapper.selectPermsByRoleId(roleId);
        selects.forEach(m -> {
            if (m != null && StringUtils.isNotBlank(m.getPerms())) {
                perms.add(m.getPerms());
            }
        });
        return perms;
    }

    @Override
    public int update(MenuEntity entity) {
        return menuMapper.update(entity);
    }

    @Override
    public int add(MenuEntity entity) {
        return menuMapper.add(entity);
    }

}
