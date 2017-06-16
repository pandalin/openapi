/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:21 创建
 *
 */
package com.jvv.openapi.core.service.listener.event;

import java.util.Map;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:21
 */

public class BeforeResponseEvent extends ServiceEvent {
	private Map<String, Object> requestData;
	
	public BeforeResponseEvent(ApiRequest apiRequest, ApiResponse apiResponse,
								Map<String, Object> requestData) {
		super(apiRequest, apiResponse);
		this.requestData = requestData;
	}
	
	public BeforeResponseEvent(Map<String, Object> requestData) {
		super(null, null);
		this.requestData = requestData;
	}
	
	public Map<String, Object> getRequestData() {
		return requestData;
	}
}
