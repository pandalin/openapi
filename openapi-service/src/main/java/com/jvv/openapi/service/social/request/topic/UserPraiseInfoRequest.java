/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request.topic;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/5/17
 * @time 11:35
 */
public class UserPraiseInfoRequest extends ApiRequest {
	
	@NotBlank
	@OpenApiField(desc = "token", constraint = "必填")
	private String token;
	
	@NotNull
	@Min (1)
	@OpenApiField(desc = "分页页码",constraint = "必填")
	private int pageNo;
	
	@NotNull
	@Min (1)
	@OpenApiField(desc = "每页最大数",constraint = "必填")
	private int pageSize;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public int getPageNo () {
		return pageNo;
	}
	
	public void setPageNo (int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getPageSize () {
		return pageSize;
	}
	
	public void setPageSize (int pageSize) {
		this.pageSize = pageSize;
	}
}
