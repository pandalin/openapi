/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.response;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
public class FreezeAccountResponseData extends AbstractResponseData{
	/***
	 * 用户冻结状态 0.冻结  1.正常
	 * */
	private Boolean frozenState;
	
	public Boolean getFrozenState () {
		return frozenState;
	}
	
	public void setFrozenState (Boolean frozenState) {
		this.frozenState = frozenState;
	}
}
