/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.user.api.UserUpSixDegreeApi;
import com.jvv.customer.facade.user.order.UserUpSixDegreeOrder;
import com.jvv.customer.facade.user.result.UserUpSixDegreeResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/28
 * @time 13:46
 */
@Component
public class UserUpSixDegreeClient extends Client {
	
	public UserUpSixDegreeResult findUpSixDegreeByUserId(UserUpSixDegreeOrder order){
		UserUpSixDegreeApi api=getDubboClient (UserUpSixDegreeApi.class);
		UserUpSixDegreeResult result=api.findUpSixDegreeByUserId (order);
		return result;
	}
}
