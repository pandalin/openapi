/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.user;

import com.jvv.customer.facade.user.api.UserDataReportApi;
import com.jvv.customer.facade.user.api.UserInfoApi;
import com.jvv.customer.facade.user.order.UserDataReportOrder;
import com.jvv.customer.facade.user.order.UserInfoOrder;
import com.jvv.customer.facade.user.result.UserDataReportResult;
import com.jvv.customer.facade.user.result.UserInfoResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author zhaoyk
 * @date
 * @time
 */

@Component
public class UserDataReportClient extends Client{
	
	public UserDataReportResult findActiveAndRegistUser(){
		UserDataReportApi api = getDubboClient (UserDataReportApi.class);
		return api.findActiveAndRegistUser ();
	}
	
	
}
