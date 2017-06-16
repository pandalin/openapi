/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:34 创建
 *
 */
package com.jvv.openapi.core.service.listener;

import com.jvv.openapi.core.service.listener.event.ApiEvent;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:34
 */

public interface SmartListenter<E extends ApiEvent> extends ApiListener<E> {
	
	/**
	 * 支持的时间类型
	 *
	 * @param eventType
	 * @return
	 */
	boolean supportsEventType (Class<E> eventType);
}
