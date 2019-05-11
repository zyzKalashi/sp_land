package com.kailash.land.entity;

import java.io.Serializable;
import java.util.List;

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
@TableName("area_code")
@EqualsAndHashCode(callSuper = false)
public class AreaCode extends Model<AreaCode> {

	private static final long serialVersionUID = 1L;
	
	@TableId(value = "code", type = IdType.AUTO)
	private Long code;
 
	@TableField(value="area_name", strategy = FieldStrategy.NOT_NULL)
	private String areaName;

	@TableField(value="level", strategy = FieldStrategy.NOT_NULL)
	private Integer level;

	@TableField(value="parent_code", strategy = FieldStrategy.NOT_NULL)
	private Long parentCode;
	
	@TableField(exist = false)
	private List<AreaCode> childAreas;
	
	@TableField(exist = false)
	private Integer areaId;

	@Override
	protected Serializable pkVal() {
		return code;
	}

}
