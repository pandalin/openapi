/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 21:52 创建
 *
 */
package com.jvv.openapi.core.service.auth.permission;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 21:52
 */

public interface PermissionResolver {
	Permission resolvePermission(String permissionString);
}
