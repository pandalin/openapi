/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-26 16:55 创建
 *
 */
package com.jvv.openapi.facade.test.order;

import com.jvv.openapi.facade.base.OpenApiOrderBase;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/26 16:55
 */

public class TestOrder extends OpenApiOrderBase {
	private String userName;

	public String getUserName () {
		return userName;
	}

	public void setUserName (String userName) {
		this.userName = userName;
	}

}
