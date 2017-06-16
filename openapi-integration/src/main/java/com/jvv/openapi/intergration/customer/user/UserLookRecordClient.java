/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.user.api.UserLookRecordApi;
import com.jvv.customer.facade.user.order.UserLookRecordOrder;
import com.jvv.customer.facade.user.result.UserLookRecordResult;
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
public class UserLookRecordClient extends Client{
	
	public UserLookRecordResult queryLookRecord(UserLookRecordOrder order){
		UserLookRecordApi api = getDubboClient (UserLookRecordApi.class);
		UserLookRecordResult result = api.queryLookRecord (order);
		return result;
	}
	
	public UserLookRecordResult queryLookedCount(UserLookRecordOrder order){
		UserLookRecordApi api = getDubboClient (UserLookRecordApi.class);
		return api.queryLookedCount(order);
	}
}
