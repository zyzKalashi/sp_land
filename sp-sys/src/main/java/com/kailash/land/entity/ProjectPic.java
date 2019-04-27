package com.kailash.land.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectPic {
	private Long proPicId;
	private Integer projectId;
	private Integer picKind;// 1-身份证，2-产权证，3合同书
	private String picUrl;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Date createDate;
	@TableField(strategy = FieldStrategy.NOT_NULL)
	private Integer createUser;

}
