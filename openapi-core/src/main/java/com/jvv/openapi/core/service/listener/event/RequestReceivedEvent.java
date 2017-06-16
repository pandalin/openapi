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

import java.util.Map;

/**
 * 收到用户请求时的事件
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:24
 */

public class RequestReceivedEvent extends SystemEvent {
	private Map<String, String> requestData;

	public RequestReceivedEvent(Map<String, String> requestData) {
		this.requestData = requestData;
	}

	public Map<String, String> getRequestData() {
		return requestData;
	}

}
