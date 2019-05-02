package com.kailash.land.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
@TableName("menu")
public class MenuEntity extends Model<MenuEntity> implements Serializable {
	
	@TableId(value = "menuId", type = IdType.AUTO)
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
	
	private List<RoleEntity> role;

	@Override
	protected Serializable pkVal() {
		return menuId;
	}
}
