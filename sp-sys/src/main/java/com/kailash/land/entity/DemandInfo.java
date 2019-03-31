package com.kailash.land.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.kailash.land.filter.DemandFilter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class DemandInfo extends Model<DemandInfo> implements Serializable {
	private Integer pkid;

	private Date createDate;

	private Integer createUser;

	private String updateDate;

	private Integer updateUser;

	private Integer demandStatus;

	private String title;

	private Integer province;

	private Integer city;

	private Integer town;

	private Integer moneyArea;

	private Integer demandNature;

	private String person;

	private String phone;

	private String email;

	private String fileUrl;

	private String detail;

	public DemandInfo(DemandFilter filter) {
		this.title = filter.getTitle();
		this.province = filter.getProvince();
		this.city = filter.getCity();
		this.town = filter.getTown();
		this.moneyArea = filter.getMoneyArea();
		this.demandNature = filter.getDemandNature();
		this.person = filter.getPerson();
		this.phone = filter.getPhone();
		this.email = filter.getEmail();
		this.detail = filter.getDetail();
	}

	@Override
	protected Serializable pkVal() {
		return pkid;
	}

}