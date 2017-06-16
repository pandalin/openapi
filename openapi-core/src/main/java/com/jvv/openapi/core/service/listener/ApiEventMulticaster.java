/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:42 创建
 *
 */
package com.jvv.openapi.core.service.listener;

import com.jvv.openapi.core.service.listener.event.ApiEvent;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:42
 */

public interface ApiEventMulticaster<E extends ApiEvent> extends ApiEventPublisher<E> {
	
	void addListener(ApiListener<E> listener);
	
	void removeListener(ApiListener<E> listener);
	
	void removeAllListeners();
}
