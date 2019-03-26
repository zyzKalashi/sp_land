package com.kailash.land.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.baomidou.mybatisplus.service.IService;
import com.kailash.land.entity.MenuEntity;

public interface MenuService extends IService<MenuEntity>{
    /**
     * 根据menuId查询对象
     *
     * @param menuId
     * @return
     */
    MenuEntity selectEntityById(Integer menuId);

    List<MenuEntity> list();

    /**
     * 根据type =1查询一级列表
     * 根据type =3 查询三级列表
     * @return
     */
    List<MenuEntity> selectListByType(int type);

    /**
     * 根据用户id查询显示的列表
     *
     * @param param
     * @return
     */
    List<MenuEntity> selectMenuListByUserId(Map<String, Object> param);

    /**
     * 根据parentId和type=-1查询二级列表查询显示的列表
     *
     * @param param
     * @return
     */
    List<MenuEntity> selectSecondByParentId(Map<String, Object> param);

    /**
     * 根据角色id查询
     *
     * @param roleId
     * @return
     */
    Set<String> selectPermsByRoleId(Integer roleId);

    /**
     * 更新对象
     *
     * @param entity
     * @return
     */
    int update(MenuEntity entity);

    /**
     * 添加对象
     *
     * @param entity
     * @return
     */
    int add(MenuEntity entity);
}
