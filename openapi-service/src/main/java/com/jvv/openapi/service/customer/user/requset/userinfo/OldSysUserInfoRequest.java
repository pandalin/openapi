/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset.userinfo;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/20
 * @time 9:49
 */
public class OldSysUserInfoRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "userId", constraint = "必填")
    private String userId;
	
	@NotNull
	@OpenApiField(desc = "userType", constraint = "必填")
    private Integer userType;
	
	public String getUserId () {
		return userId;
	}
	
	public void setUserId (String userId) {
		this.userId = userId;
	}
	
	public Integer getUserType () {
		return userType;
	}
	
	public void setUserType (Integer userType) {
		this.userType = userType;
	}
}
