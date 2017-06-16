/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;

import com.jvv.customer.facade.user.order.UserDealpwdErrorOrder;
import com.jvv.customer.facade.user.result.UserDealpwdErrorResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.UserDealpwdErrorClient;
import com.jvv.openapi.service.customer.user.requset.UserDealpwdErrorRequest;
import com.jvv.openapi.service.customer.user.response.UserDealpwdErrorResponse;
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
@OpenApiService(name = "clearErrorCount", desc = "清除用户安全码误次", responseType = ResponseTypeEnum.SYN)
public class UserDealpwdErrorApiService extends AbstractApiService<UserDealpwdErrorRequest,UserDealpwdErrorResponse>{
	
	@Resource
	private UserDealpwdErrorClient userDealpwdErrorClient;
	@Resource
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (UserDealpwdErrorRequest request, UserDealpwdErrorResponse response) {
		UserDealpwdErrorOrder order = new UserDealpwdErrorOrder ();
		BeanUtils.copyProperties (request,order);
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		order.setUserId (userId);
		
		UserDealpwdErrorResult result = userDealpwdErrorClient.clearErrorCount (order);
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
	}
}
