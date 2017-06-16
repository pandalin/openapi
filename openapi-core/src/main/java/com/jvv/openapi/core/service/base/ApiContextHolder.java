/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 20:56 创建
 *
 */
package com.jvv.openapi.core.service.base;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 20:56
 */

public class ApiContextHolder {
	static final ThreadLocal<ApiContext> apiContextThreadLocal = new ThreadLocal<ApiContext>();

	public static ApiContext getApiContext() {
		ApiContext apiContext = apiContextThreadLocal.get();
		return apiContext;
	}
}
