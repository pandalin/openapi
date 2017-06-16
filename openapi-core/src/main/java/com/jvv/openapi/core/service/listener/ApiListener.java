/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:27 创建
 *
 */
package com.jvv.openapi.core.service.listener;

import java.util.EventListener;

import com.jvv.openapi.core.service.listener.event.ApiEvent;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:27
 */

public interface ApiListener<E extends ApiEvent> extends EventListener, Sortable {
	
	/**
	 * 触发事件
	 * @param event
	 */
	void onEvent(E event);
}
