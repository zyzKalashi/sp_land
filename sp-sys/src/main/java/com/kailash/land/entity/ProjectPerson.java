package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.kailash.land.filter.ProjectFiter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class ProjectPerson extends Model<ProjectPerson> implements Serializable {

	private Integer pkid;

	private Date createDate;

	private Integer createUser;

	private String updateDate;

	private Integer updateUser;

	private Integer projectId;

	private String name;

	private Integer sex;

	private Integer infoKind;

	private String mobile;

	private String idCard;

	private String address;

	public ProjectPerson(ProjectFiter filter) {
		this.name = filter.getName();
		this.sex = filter.getSex();
		this.infoKind = filter.getInfoKind();
		this.mobile = filter.getMobile();
		this.idCard = filter.getIdCard();
		this.address = filter.getAddress();
	}

	@Override
	protected Serializable pkVal() {
		return pkid;
	}
}
