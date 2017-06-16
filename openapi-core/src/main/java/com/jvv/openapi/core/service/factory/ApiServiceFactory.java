/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:38 创建
 *
 */
package com.jvv.openapi.core.service.factory;

import com.jvv.openapi.core.service.base.ApiService;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:38
 */

public interface ApiServiceFactory {
	ApiService getApiService(String serviceName, String version);
}
