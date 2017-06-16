/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/4/6
 * @time 17:08
 */
public class QueryGroupRequest extends ApiRequest{
	
	/**
	 * 开始分页
	 */
	@OpenApiField(desc = "当前页")
	private Long start=1L;
	
	/**
	 * 每页最大调试
	 */
	@OpenApiField(desc = "每页包含条数")
	private Integer pageSize=10;
	
	/**
	 * 查询条件
	 */
	@NotNull
	@OpenApiField(desc = "查询条件")
	private String condition;
	
	public String getCondition () {
		return condition;
	}
	
	public void setCondition (String condition) {
		this.condition = condition;
	}
	
	public Long getStart () {
		return start;
	}
	
	public void setStart (Long start) {
		this.start = start;
	}
	
	public Integer getPageSize () {
		return pageSize;
	}
	
	public void setPageSize (Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
