/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:57 创建
 *
 */
package com.jvv.openapi.core.service.base;

import com.jvv.openapi.core.service.meta.FrameworkOnly;

/**
 * 仅限框架内调用
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:57
 */
@FrameworkOnly
public class InternalApiContextHolder {
	/**
	 * 仅限框架内调用
	 */
	@FrameworkOnly
	public static void init() {
		ApiContext apiContext = ApiContextHolder.apiContextThreadLocal.get();
		if (apiContext == null) {
			apiContext = new ApiContext();
			ApiContextHolder.apiContextThreadLocal.set(apiContext);
		}
	}
	
	public static ApiContext getApiContext() {
		ApiContext apiContext = ApiContextHolder.apiContextThreadLocal.get();
		return apiContext;
	}
	
	/**
	 * 仅限框架内调用
	 */
	@FrameworkOnly
	public static void setApiContext(ApiContext apiContext) {
		if (apiContext != null) {
			ApiContextHolder.apiContextThreadLocal.set(apiContext);
		}
	}
	
	/**
	 * ApiContextHolder是否已经初始化
	 *
	 * 仅限框架内调用
	 * @return
	 */
	@FrameworkOnly
	public static boolean isInited() {
		return !(ApiContextHolder.apiContextThreadLocal.get() == null);
	}
	
	/**
	 * 仅限框架内调用
	 *
	 */
	@FrameworkOnly
	public static void clear() {
		ApiContextHolder.apiContextThreadLocal.remove();
	}
}
