/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 21:01 创建
 *
 */
package com.jvv.openapi.core.service.base;

import com.jvv.openapi.core.service.ApiServiceException;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.listener.ApiEventMulticaster;
import com.jvv.openapi.core.service.listener.ApiListener;
import com.jvv.openapi.core.service.listener.event.ServiceEvent;
import com.jvv.openapi.core.service.listener.multicaster.ServiceEventMulticaster;
import com.jvv.openapi.core.util.GenericsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * 服务层框架:泛型和拦截封装
 * 
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 21:01
 */

public abstract class GeneralApiService<O extends ApiRequest, R extends ApiResponse>
																						implements
																						ApiService<O, R> {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ApiEventMulticaster serviceEventMulticaster = new ServiceEventMulticaster();
	
	private Class<O> requestClazz;
	private Class<R> responseClazz;
	
	@Override
	public O getRequestBean() {
		if (requestClazz == null) {
			requestClazz = GenericsUtils.getSuperClassGenricType(getClass(), 0);
		}
		try {
			if (requestClazz.equals(Object.class)) {
				return (O) new ApiRequest();
			} else {
				return BeanUtils.instantiate(requestClazz);
			}
		} catch (Exception e) {
			throw new ApiServiceException("实例化Request对象失败:" + requestClazz.toString());
		}
	}
	
	@Override
	public R getResponseBean() {
		if (responseClazz == null) {
			responseClazz = GenericsUtils.getSuperClassGenricType(getClass(), 1);
		}
		try {
			if (responseClazz.equals(Object.class)) {
				return (R) new ApiResponse();
			} else {
				return BeanUtils.instantiate(responseClazz);
			}
		} catch (Exception e) {
			throw new ApiServiceException("实例化Response对象失败:" + responseClazz.toString());
		}
	}
	
	/**
	 * 添加服务监听器
	 *
	 * @param listener
	 */
	protected void addListener(ApiListener<? extends ServiceEvent> listener) {
		serviceEventMulticaster.addListener(listener);
	}
	
	/**
	 * 删除服务监听器
	 *
	 * @param listener
	 */
	protected void removeListener(ApiListener<? extends ServiceEvent> listener) {
		serviceEventMulticaster.removeListener(listener);
	}
	
	/**
	 * 删除所有服务监听器
	 */
	protected void removeAllListeners() {
		serviceEventMulticaster.removeAllListeners();
	}
	
	@Override
	public void publish(ServiceEvent event) {
		serviceEventMulticaster.publish(event);
	}
	
	@Override
	public boolean canPublish() {
		return serviceEventMulticaster.canPublish();
	}
}
