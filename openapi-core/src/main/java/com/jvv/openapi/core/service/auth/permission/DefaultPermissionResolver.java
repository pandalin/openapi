/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 21:54 创建
 *
 */
package com.jvv.openapi.core.service.auth.permission;

import com.jvv.openapi.core.service.ApiConstants;
import org.springframework.stereotype.Service;

/**
 * 权限解析器
 * 
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 21:54
 */
@Service("permissionResolver")
public class DefaultPermissionResolver implements PermissionResolver {
	
	@Override
	public Permission resolvePermission(String permissionString) {
		if (ApiConstants.WILDCARD_TOKEN.equals(permissionString)) {
			return new AllPermission();
		}
		return new DefaultPermission(permissionString);
	}
}
