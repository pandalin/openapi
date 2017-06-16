/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 21:59 创建
 *
 */
package com.jvv.openapi.core.service.auth.impl;

import java.util.List;

import com.jvv.openapi.core.service.auth.ApiAuthorizer;
import com.jvv.openapi.core.service.auth.ApiServiceAuthException;
import com.jvv.openapi.core.service.auth.permission.Permission;
import org.springframework.stereotype.Service;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 21:59
 */
@Service("apiAuthorizer")
public class DefaultApiAuthorizer implements ApiAuthorizer {
	@Override
	public void authorize(String serviceName, List<Permission> permissionList) {
		if (permissionList != null) {
			for (Permission perm : permissionList) {
				if (perm.implies(serviceName)) {
					return;
				}
			}
		}
		
		throw new ApiServiceAuthException ("服务[" + serviceName + "]未授权");
	}
}
