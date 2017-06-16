/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.reminder;

import com.jvv.customer.facade.base.result.SimpleResult;
import com.jvv.customer.facade.user.order.UserReminderSettingOrder;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserReminderSettingClient;
import com.jvv.openapi.service.customer.user.requset.reminder.UserReminderSettingRequest;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date
 * @time
 */
@OpenApiService (name = "removeReminder",desc = "移除一条用户设置信息",responseType = ResponseTypeEnum.SYN)
public class UserReminderRemoveApiService extends AbstractApiService<UserReminderSettingRequest,ApiResponse>{
	
	@Resource
	private UserReminderSettingClient userReminderSettingClient;
	@Resource
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserReminderSettingRequest request, ApiResponse response) {
		UserReminderSettingOrder order = new UserReminderSettingOrder ();
		BeanUtils.copyProperties (request,order);
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		order.setUserid (userId);
		SimpleResult result = userReminderSettingClient.remove (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
	}
}
