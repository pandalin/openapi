/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2017-03-13 22:16 创建
 *
 */
package com.jvv.openapi.intergration.demo;

import com.jvv.customer.facade.demo.api.DemoUserApi;
import com.jvv.customer.facade.demo.order.DemoUserOrder;
import com.jvv.customer.facade.demo.result.DemoUserResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * @author turalyon@jinvovo.com
 */

@Component
public class DemoClient extends Client {

	public DemoUserResult getUserById(String userId){
		DemoUserApi api = getDubboClien(DemoUserApi.class,DUBBO_DEFAULT_VERSION,"1.0");

		DemoUserOrder userOrder = new DemoUserOrder();
		userOrder.setUserId(userId);

		return api.findById(userOrder);
	}
}
