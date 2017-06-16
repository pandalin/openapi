/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.social.request;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiField;
import com.jvv.openapi.core.service.meta.OpenApiService;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/4/10
 * @time 16:21
 */
public class FindUserByPhoneRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "token")
	private String token;
	
	@NotNull
	@OpenApiField(desc = "手机号")
	private String userPhone;
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public String getUserPhone () {
		return userPhone;
	}
	
	public void setUserPhone (String userPhone) {
		this.userPhone = userPhone;
	}
}
