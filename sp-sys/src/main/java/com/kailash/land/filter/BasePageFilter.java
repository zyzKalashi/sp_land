package com.kailash.land.filter;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页类
 * 
 * @Author: jinjx
 * @Date: Create in 2018/4/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("serial")
public class BasePageFilter implements Serializable {

	private int pageNo;

	private int pageSize;

	/* zyz 排序 */
	private String orderKey;

	private String orderName;

}
