/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 21:04 创建
 *
 */
package com.jvv.openapi.core.service.listener.multicaster;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.jvv.openapi.core.service.base.ApiService;
import com.jvv.openapi.core.service.listener.ApiListener;
import com.jvv.openapi.core.service.listener.event.SystemEvent;
import com.jvv.openapi.core.service.meta.OpenApiEventListener;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 21:04
 */

@Service
public class EventPublisher implements InitializingBean {
	private static final Logger logger = LoggerFactory.getLogger(EventPublisher.class);
	
	@Resource
	private ApplicationContext applicationContext;
	
	private SystemEventMulticaster systemEventMulticaster = new SystemEventMulticaster();
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, ApiListener> openApiListenerBeansMap = applicationContext
			.getBeansOfType(ApiListener.class);
		for (ApiListener apiListener : openApiListenerBeansMap.values()) {
			OpenApiEventListener listener = apiListener.getClass().getAnnotation(
				OpenApiEventListener.class);
			if (listener != null && listener.global()) {
				systemEventMulticaster.addListener(apiListener);
				logger.info("加载openapi全局监听器:{}", apiListener.getClass().getName());
			}
		}
		
	}
	
	/**
	 * 发布事件到全局事件监听器和服务事件监听器
	 * @param event
	 * @param service
	 */
	public void publishEvent(SystemEvent event, ApiService service) {
		if (systemEventMulticaster != null) {
			systemEventMulticaster.publish(event);
		}
		if (service != null) {
			service.publish(event);
		}
	}
	
	/**
	 * 发布事件到全局事件监听器
	 * @param event
	 */
	public void publishEvent(SystemEvent event) {
		systemEventMulticaster.publish(event);
	}
	
	public boolean canPublishGlobalEvent() {
		return systemEventMulticaster != null && systemEventMulticaster.canPublish();
	}
	
	public boolean canPublishEvent(ApiService service) {
		return systemEventMulticaster.canPublish() || (service != null && service.canPublish());
	}
}
