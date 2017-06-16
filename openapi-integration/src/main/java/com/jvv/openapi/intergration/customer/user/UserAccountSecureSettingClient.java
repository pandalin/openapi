/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.user.api.UserAccountSecureSettingApi;
import com.jvv.customer.facade.user.order.UserAccountSecureSettingOrder;
import com.jvv.customer.facade.user.result.UserAccountSecureSettingResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author lxb
 * @date 2017/3/21
 * @time 18:17
 */
@Component
public class UserAccountSecureSettingClient extends Client {
	public UserAccountSecureSettingResult queruAccounSecureSetting(UserAccountSecureSettingOrder order){
		UserAccountSecureSettingApi accountSecureSettingApi=getDubboClient (UserAccountSecureSettingApi.class);
		UserAccountSecureSettingResult result=accountSecureSettingApi.queryAccounSecureSetting (order);
		//System.out.println ("===>"+result);
		return result;
	}
	
}
