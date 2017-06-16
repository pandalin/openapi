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
 * @author Huangw
 * @date 2017/4/12
 * @time 16:01
 */
public class FindMsgFriendRequest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "token")
	private String token;

	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}

}
