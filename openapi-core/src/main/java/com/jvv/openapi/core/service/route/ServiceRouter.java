/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-24 20:47 创建
 *
 */
package com.jvv.openapi.core.service.route;

import com.jvv.openapi.core.service.base.ApiService;

import java.util.Collection;

/**
 * 服务路由器
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/24 20:47
 */

public interface ServiceRouter {
	ApiService route(String serviceName, String version, Collection<ApiService> apiServices);
}
