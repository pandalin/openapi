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


/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 21:54
 */

public class AllPermission implements Permission {
	@Override
	public boolean implies(String resource) {
		return true;
	}
}
