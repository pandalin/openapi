/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 19:41 创建
 *
 */
package com.jvv.openapi.core.service.listener;

import com.jvv.openapi.core.service.listener.event.ApiEvent;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 19:41
 */

public interface ApiEventPublisher<E extends ApiEvent> {
	/**
	 * 发布此事件
	 * @param event
	 */
	void publish(E event);
	
	/**
	 * 是否可以发布此事件
	 * @return
	 */
	boolean canPublish();
}
