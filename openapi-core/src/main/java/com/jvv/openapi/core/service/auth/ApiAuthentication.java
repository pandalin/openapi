/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 22:02 创建
 *
 */
package com.jvv.openapi.core.service.auth;

import com.jvv.openapi.core.service.entity.ApiRequest;

import java.util.Map;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 22:02
 */

public interface ApiAuthentication {
	/**
	 * 商户状态检查
	 * @param request
	 */
	void checkMerchant(ApiRequest request);

	void authenticate(ApiRequest request);

	void signature(Map<String, String> response);

	void signature(Map<String, String> responseData, String partnerId, String signType);
}
