/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 19:59 创建
 *
 */
package com.jvv.openapi.core.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jvv.openapi.core.servlet.executor.HttpApiServiceExecutor;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 19:59
 */

public class OpenApiDispatchServlet extends AbstractSpringServlet {

	@Override
	protected void doService(String method, HttpServletRequest request, HttpServletResponse response)
																										throws FrameworkServletException {
		HttpApiServiceExecutor executor = getBean("httpApiServiceExecutor",
			HttpApiServiceExecutor.class);
		executor.execute(request, response);
	}
}
