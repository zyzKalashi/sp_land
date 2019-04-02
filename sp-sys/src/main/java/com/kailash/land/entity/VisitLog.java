package com.kailash.land.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("visit_log")
public class VisitLog extends Model<VisitLog> {

	@TableId(value = "pkid", type = IdType.AUTO)
	private Long pkid;
	/*
	 * 1.项目 2.需求
	 */
	private Integer bizKind;
	private Long bizId;
	private Integer visitNum;

	@Override
	protected Serializable pkVal() {
		return pkid;
	}

	public VisitLog(Integer bizKind, Long bizId) {
		this.bizKind = bizKind;
		this.bizId = bizId;
	}
}
