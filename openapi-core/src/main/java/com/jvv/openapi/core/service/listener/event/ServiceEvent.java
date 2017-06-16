/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 19:44 创建
 *
 */
package com.jvv.openapi.core.service.listener.event;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 19:44
 */

public class ServiceEvent extends SystemEvent {
	private ApiResponse apiResponse = null;
	private ApiRequest apiRequest = null;
	
	public ServiceEvent(ApiRequest apiRequest, ApiResponse apiResponse) {
		this.apiResponse = apiResponse;
		this.apiRequest = apiRequest;
	}
	
	public ApiResponse getApiResponse() {
		return apiResponse;
	}
	
	public ApiRequest getApiRequest() {
		return apiRequest;
	}
}
