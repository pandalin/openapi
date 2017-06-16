/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-23 21:39 创建
 *
 */
package com.jvv.openapi.core.service.auth.realm;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/23 21:39
 */

public interface AuthInfoRealm {
	Object getAuthenticationInfo(String partnerId);

	Object getAuthorizationInfo(String partnerId);
}
