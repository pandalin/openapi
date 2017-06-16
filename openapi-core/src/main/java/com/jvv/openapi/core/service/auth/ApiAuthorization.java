/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 22:33 创建
 *
 */
package com.jvv.openapi.core.service.auth;

import com.jvv.openapi.core.service.entity.ApiRequest;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 22:33
 */

public interface ApiAuthorization {

	void authorize(ApiRequest apiRequest);
}
