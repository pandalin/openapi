/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:17 创建
 *
 */
package com.jvv.openapi.core.service.listener.event;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;

/**
 * 服务执行之前的事件
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:17
 */

public class BeforeServiceExecuteEvent extends ServiceEvent {
	public BeforeServiceExecuteEvent(ApiRequest apiRequest, ApiResponse apiResponse) {
		super(apiRequest, apiResponse);
	}
}
