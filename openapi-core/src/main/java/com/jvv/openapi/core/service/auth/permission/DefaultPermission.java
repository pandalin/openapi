/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 21:53 创建
 *
 */
package com.jvv.openapi.core.service.auth.permission;


import com.jvv.openapi.core.service.ApiConstants;

/**
 * 匹配一个星号的授权.
 * <p/>
 * 比如:商户系统可以配置*,代表此商户拥有所有权限.
 * <p/>
 * 配置xxx*,代表仅开通xxx开头的服务
 * <p/>
 * 预期openapi以后会有服务分级的概念.
 *
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 21:53
 */

public class DefaultPermission implements Permission {
	/**
	 * 权限字符串
	 */
	private String perm;

	public DefaultPermission(String perm) {
		this.perm = perm;
	}

	@Override
	public boolean implies(String resource) {
		if (perm.equals(resource) || perm.equals(ApiConstants.WILDCARD_TOKEN)) {
			return true;
		}
		int idx = perm.indexOf(ApiConstants.WILDCARD_TOKEN);
		if (idx < 0) {
			return false;
		} else {
			String pp = perm.substring(0, idx);
			String pe = perm.substring(idx + 1);
			return resource.startsWith(pp) && resource.endsWith(pe);
		}
	}
}
