/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 21:04 创建
 *
 */
package com.jvv.openapi.core.service.base;

import com.jvv.openapi.core.exception.FrameworkException;
import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Api Service 抽象模板实现
 * <p/>
 * service处理模板，统一错误处理
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 21:04
 */

public abstract class AbstractApiService<O extends ApiRequest, R extends ApiResponse>
																						extends
																						GeneralApiService<O, R> {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 默认重定向地址
	 */
	private String defaultRedirectUrl;
	
	@Override
	public final void service(O request, R response) {
		try {
			logger.info ("==>>>收到请求：request={}",request);
			doService (request, response);
			logger.info ("<<<==处理结果:response={}",response);
		} catch (FrameworkException e) {
			throw e;
		} catch (Exception e) {
			throw new FrameworkException(e);
		}
	}
	
	/**
	 * 服务处理方法
	 * <p/>
	 * 如果抛出非ApiServiceException异常,对外响应内部错误
	 * <p/>
	 * 如果抛出ApiServiceException异常,会根据异常的信息返回给用户
	 * <p/>
	 *
	 * @param request
	 * @param response
	 */
	protected abstract void doService(O request, R response);
	
	protected String getGid() {
		return ApiContextHolder.getApiContext().getGid();
	}
	
	/**
	 * 设置重定向url地址
	 * <p/>
	 * 如果在服务初始化时设置的是默认重定向地址.在服务执行过程中设置的是本次请求的重定向地址.
	 * <p/>
	 * 本次请求的重定向地址优先被使用
	 *
	 * @param redirectUrl
	 */
	public final void setRedirectUrl(String redirectUrl) {
		if (!InternalApiContextHolder.isInited()) {
			this.defaultRedirectUrl = redirectUrl;
		} else {
			ApiContextHolder.getApiContext().setRedirectUrl(redirectUrl);
		}
	}
	
	public final String getDefaultRedirectUrl() {
		return defaultRedirectUrl;
	}

}
