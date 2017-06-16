/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:35 创建
 *
 */
package com.jvv.openapi.core.service.listener;

import com.jvv.openapi.core.service.listener.event.ApiEvent;
import com.jvv.openapi.core.util.GenericsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:35
 */

public abstract class AbstractListener<E extends ApiEvent> implements SmartListenter<E> {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Class<E> clazz;
	
	public AbstractListener() {
		Class clazz = GenericsUtils.getSuperClassGenricType(getClass(), 0);
		if (clazz.equals(Object.class)) {
			throw new ApiEventException("监听器:" + this.getClass().getName() + "的类型参数必须是"
										+ ApiEvent.class.getName() + "的子类");
		}
		this.clazz = clazz;
	}
	
	@Override
	public boolean supportsEventType (Class<E> eventType) {
		if (eventType == null) {
			return false;
		}
		return clazz.isAssignableFrom(eventType);
	}
}
