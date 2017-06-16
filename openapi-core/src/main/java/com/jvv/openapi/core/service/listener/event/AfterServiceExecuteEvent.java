/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:20 创建
 *
 */
package com.jvv.openapi.core.service.listener.event;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;

/**
 * 服务执行完后的事件
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:20
 */

public class AfterServiceExecuteEvent extends ServiceEvent {
	public AfterServiceExecuteEvent(ApiRequest apiRequest, ApiResponse apiResponse) {
		super(apiRequest, apiResponse);
	}
}
