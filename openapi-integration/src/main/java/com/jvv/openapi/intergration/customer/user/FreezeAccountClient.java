/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.user.api.FreezeAccountApi;
import com.jvv.customer.facade.user.order.FreezeAccountOrder;
import com.jvv.customer.facade.user.result.FreezeAccountResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
@Component
public class FreezeAccountClient extends Client{
	
	public FreezeAccountResult updateAccountState(FreezeAccountOrder order,String remark){
		FreezeAccountApi api = getDubboClient (FreezeAccountApi.class);
		FreezeAccountResult result = api.updateAccountState (order, remark);
		return result;
	}
}
