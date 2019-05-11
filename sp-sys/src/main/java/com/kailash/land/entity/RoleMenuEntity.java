package com.kailash.land.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
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
@TableName("role_menu")
public class RoleMenuEntity extends Model<RoleMenuEntity> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId(value = "pkid", type = IdType.AUTO)
	private Integer pkid;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer roleId;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer menuId;

	@Override
	protected Serializable pkVal() {
		return pkid;
	}

}