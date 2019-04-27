package com.kailash.land.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.kailash.land.filter.ProjectFiter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
@TableName("project_person")
public class ProjectPerson extends Model<ProjectPerson> implements Serializable {
	@TableId(value = "pkid", type = IdType.AUTO)
	private Long pkid;

	private Long projectId;

	private String name;

	private Integer sex;

	private Integer townCode;

	private Integer areaCode;

	private Integer infoKind;

	private String mobile;

	private String address;

	@Override
	protected Serializable pkVal() {
		return pkid;
	}

	public ProjectPerson(ProjectFiter filter) {
		this.pkid = filter.getProjectPersonId();
		this.name = filter.getName();
		this.sex = filter.getSex();
		this.townCode = filter.getTownCode();
		this.areaCode = filter.getAreaCode();
		this.infoKind = filter.getInfoKind();
		this.mobile = filter.getMobile();
		this.address = filter.getAddress();
	}
}
