package com.kailash.land.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class NoticeInfo extends BaseEntity implements Serializable {
	private Integer noticeStatus;

	private String title;

	private String companyName;

	private Integer noticeKind;

	private String noticeText;
}
