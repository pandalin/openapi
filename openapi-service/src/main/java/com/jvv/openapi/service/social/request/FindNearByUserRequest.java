/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/10
 * @time 14:31
 */
public class FindNearByUserRequest extends ApiRequest {
	@NotNull
	@OpenApiField(desc = "token")
	private String token;
	
	@OpenApiField(desc = "选择的身份")
	private String identity;
	
	@NotNull
	@OpenApiField(desc = "当前页")
	private Integer pageNo;
	
	@NotNull
	@OpenApiField(desc = "每页大小")
	private Integer pageSize;
	
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public Integer getPageNo () {
		return pageNo;
	}
	
	public void setPageNo (Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	public Integer getPageSize () {
		return pageSize;
	}
	
	public void setPageSize (Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getIdentity () {
		return identity;
	}
	
	public void setIdentity (String identity) {
		this.identity = identity;
	}
}
