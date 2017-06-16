/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 21:57 创建
 *
 */
package com.jvv.openapi.core.service.auth;


import com.jvv.openapi.core.service.auth.permission.Permission;

import java.util.List;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 21:57
 */

public interface ApiAuthorizer {
	void authorize(String serviceName, List<Permission> permissionList);
}
