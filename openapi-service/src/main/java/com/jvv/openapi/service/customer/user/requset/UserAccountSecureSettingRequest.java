/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/21
 * @time 18:23
 */
public class UserAccountSecureSettingRequest extends ApiRequest {
	@NotNull
	@OpenApiField(desc = "token",constraint = "必填")
	private String token;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
}
