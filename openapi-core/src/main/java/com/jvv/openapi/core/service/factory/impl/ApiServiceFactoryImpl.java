/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:38 创建
 *
 */
package com.jvv.openapi.core.service.factory.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.jvv.openapi.core.service.ApiServiceException;
import com.jvv.openapi.core.service.base.ApiService;
import com.jvv.openapi.core.service.factory.ApiServiceFactory;
import com.jvv.openapi.core.service.marshall.ObjectAccessor;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.service.route.ServiceRouter;

/**
 * 服务工厂
 *
 * 根据服务命名约定查找spring容器内的服务
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:38
 */

@Service
public class ApiServiceFactoryImpl implements ApiServiceFactory, ApplicationContextAware,
									InitializingBean {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiServiceFactoryImpl.class);
	
	private ApplicationContext applicationContext;
	
	private Multimap<String, ApiService> servicesMap = null;
	
	@Resource(name = "defaultServiceRouter")
	private ServiceRouter serviceRouter;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		servicesMap = HashMultimap.create();
		Map<String, ApiService> apiServiceBeansMap = applicationContext
			.getBeansOfType(ApiService.class);
		if (apiServiceBeansMap.isEmpty()) {
			logger.warn("openapi没有对外提供服务");
			return;
		}
		for (ApiService apiService : apiServiceBeansMap.values()) {
			registerService(apiService, servicesMap);
		}
	}
	
	private void registerService(ApiService curApiService, Multimap<String, ApiService> servicesMap) {
		OpenApiService openApiService = getOpenApiServiceAnnotation(curApiService);
		if (openApiService == null) {
			throw new ApiServiceException(
				"openapi服务" + curApiService.getClass()
						+ "必须要标记com.jvv.openapi.core.service.meta.FrameworkService注解");
		}
		if (servicesMap.containsKey(openApiService.name())) {
			Iterator<ApiService> iterator = servicesMap.get(openApiService.name()).iterator();
			while (iterator.hasNext()) {
				ApiService apiService = iterator.next();
				if (getOpenApiServiceAnnotation(apiService).version().equals(
					openApiService.version())) {
					throw new ApiServiceException("服务冲突:" + curApiService.getClass() + "和"
													+ apiService.getClass());
				}
			}
		}
		servicesMap.put(openApiService.name(), curApiService);
		logger.info("加载openapi服务[{}] {}:{}  {} {}", openApiService.desc(), openApiService.name(),
			openApiService.version(), curApiService.getClass().getName(), openApiService
				.responseType().name());
		//启动时检查是否有属性名重复的情况.并加载缓存
		ObjectAccessor.of(curApiService.getRequestBean());
		ObjectAccessor.of(curApiService.getResponseBean());
	}
	
	/**
	 * @param serviceName
	 * @param version
	 * @return
	 */
	@Override
	public ApiService getApiService(String serviceName, String version) {
		Collection<ApiService> apiServices = servicesMap.get(serviceName);
		return serviceRouter.route(serviceName, version, apiServices);
	}
	
	private OpenApiService getOpenApiServiceAnnotation(ApiService apiService) {
		return apiService.getClass().getAnnotation(OpenApiService.class);
		
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
