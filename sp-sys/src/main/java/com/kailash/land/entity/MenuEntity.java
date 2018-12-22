package com.kailash.land.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class MenuEntity implements Serializable {

	private Long menuId;

    private Long parentId;

    private String name;

    private String url;

    private String perms;
    /**
     * 菜单级别，1，2，3
     */
    private Integer type;

    private Integer orderNum;

    private String iconName;

    /**
     * 菜单样式
     */
    private String classStr;

    private List<MenuEntity> seconds;
}
