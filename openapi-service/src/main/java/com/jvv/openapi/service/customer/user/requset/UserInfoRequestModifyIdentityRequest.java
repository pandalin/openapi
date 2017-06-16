/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset;

import com.jvv.customer.facade.constants.validation.Modify;
import com.jvv.customer.facade.constants.validation.Query;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author zhaoyk
 * @date
 * @time
 */
public class UserInfoRequestModifyIdentityRequest extends ApiRequest {
	/**
	 * 用户ID(唯一标示)
	 */
	@NotNull
	@OpenApiField(desc = "token")
	protected String token;
	/**
	 * 身份
	 */
	@NotNull
	@OpenApiField(desc = "身份")
	protected String identity;
	/**
	 * 性别
	 */
	@NotNull
	@OpenApiField(desc = "性别")
	protected Integer level;
	
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String userId) {
		this.token = userId;
	}
	
	public String getIdentity () {
		return identity;
	}
	
	public void setIdentity (String identity) {
		this.identity = identity;
	}
	
	public Integer getLevel () {
		return level;
	}
	
	public void setLevel (Integer level) {
		this.level = level;
	}
}