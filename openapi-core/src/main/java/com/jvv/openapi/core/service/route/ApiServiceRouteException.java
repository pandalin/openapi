/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:49 创建
 *
 */
package com.jvv.openapi.core.service.route;

import com.jvv.openapi.core.service.ApiServiceException;
import com.jvv.openapi.core.service.base.ApiServiceResultCode;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:49
 */

public class ApiServiceRouteException extends ApiServiceException {
	public ApiServiceRouteException(String serviceName, Object version) {
		super(ApiServiceResultCode.SERVICE_NOT_FOUND_ERROR, "请求服务[" + serviceName + ":" + version
															+ "]不存在");
	}
}
