/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request;

import com.jvv.common.services.order.validation.Query;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/4/11
 * @time 9:42
 */
public class UserInterpersonalRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "token", constraint = "必填")
	private String token;
	@NotNull
	@OpenApiField(desc = "当前页", constraint = "必填")
	private Long start;
	@NotNull
	@OpenApiField(desc = "每页大小", constraint = "必填")
	private Integer pageSize;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
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
