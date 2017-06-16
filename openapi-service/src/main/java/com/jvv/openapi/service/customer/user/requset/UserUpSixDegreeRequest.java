/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.requset;

import com.jvv.customer.facade.constants.validation.Query;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/28
 * @time 15:13
 */
public class UserUpSixDegreeRequest extends ApiRequest {
	@NotNull
	@OpenApiField(desc = "用户id", constraint = "必填")
	private String userId;
	
	public String getUserId () {
		return userId;
	}
	
	public void setUserId (String userId) {
		this.userId = userId;
	}
}
