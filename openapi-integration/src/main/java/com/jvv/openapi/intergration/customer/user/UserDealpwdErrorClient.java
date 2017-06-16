/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.user.api.UserDealpwdErrorApi;
import com.jvv.customer.facade.user.order.UserDealpwdErrorOrder;
import com.jvv.customer.facade.user.result.UserDealpwdErrorResult;
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
public class UserDealpwdErrorClient extends Client{
	
	public UserDealpwdErrorResult clearErrorCount(UserDealpwdErrorOrder order){
		UserDealpwdErrorApi api = getDubboClient (UserDealpwdErrorApi.class);
		UserDealpwdErrorResult result = api.clearErrorCount (order);
		return result;
	}
}
