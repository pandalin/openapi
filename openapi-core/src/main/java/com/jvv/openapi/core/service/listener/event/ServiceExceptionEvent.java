/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:24 创建
 *
 */
package com.jvv.openapi.core.service.listener.event;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:24
 */

public class ServiceExceptionEvent extends AfterServiceExecuteEvent {
	private Throwable throwable;
	
	public ServiceExceptionEvent(ApiRequest apiRequest, ApiResponse apiResponse, Throwable ex) {
		super(apiRequest, apiResponse);
		this.throwable = ex;
	}
	
	public Throwable getThrowable() {
		return throwable;
	}
}
