package com.kailash.land.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RoleEntity extends Model<RoleEntity> {
	
	private static final long serialVersionUID = 1L;

	@TableId(value = "role_id", type = IdType.AUTO)
	private Integer roleId;

	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String roleKey;

	@TableField(strategy = FieldStrategy.NOT_NULL)
	private String roleName;

	@TableField(exist = false)
	private Integer roleMenuId;
	@TableField(exist = false)
	private Integer hasRole;
	@TableField(exist = false)
	private Integer menuId;

	@Override
	protected Serializable pkVal() {
		return roleId;
	}

}