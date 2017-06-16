/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:50 创建
 *
 */
package com.jvv.openapi.core.exception.handler;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.entity.ApiResponse;

/**
 * 服务框架错误统一处理接口
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:50
 */

public interface ApiServiceExceptionHandler {

	void handle(ApiRequest apiRequest, ApiResponse apiResponse, Throwable ase);


}
