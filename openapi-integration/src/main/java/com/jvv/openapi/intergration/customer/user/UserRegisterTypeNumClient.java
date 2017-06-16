/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.user.api.UserRegisterTypeNumApi;
import com.jvv.customer.facade.user.order.UserRegisterTypeNumByDateOrder;
import com.jvv.customer.facade.user.result.UserRegisterTypeNumResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/17
 * @time 17:00
 */
@Component
public class UserRegisterTypeNumClient extends Client {
	
	public UserRegisterTypeNumResult queryRegisterTypeNum(UserRegisterTypeNumByDateOrder order){
		UserRegisterTypeNumApi api=getDubboClient (UserRegisterTypeNumApi.class);
		return api.queryRegisterTypeCount (order);
	}
}
