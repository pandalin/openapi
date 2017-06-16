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
 * @author liujf
 * @date
 * @time
 */
public class FreezeAccountRequest extends ApiRequest{
	
	@NotNull
	@OpenApiField(desc = "token")
	private String token;
	
	@NotNull
	@OpenApiField(desc = "冻结状态")
	private Integer frozenState;
	
	@OpenApiField(desc = "冻结账户时添加的备注")
	private String remark;
	
	public String getRemark () {
		return remark;
	}
	
	public void setRemark (String remark) {
		this.remark = remark;
	}
	
	public String getToken () {
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}
	
	public Integer getFrozenState () {
		return frozenState;
	}
	
	public void setFrozenState (Integer frozenState) {
		this.frozenState = frozenState;
	}
}
