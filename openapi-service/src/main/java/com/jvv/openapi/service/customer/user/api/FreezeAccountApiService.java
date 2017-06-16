/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api;

import com.jvv.customer.facade.user.order.FreezeAccountOrder;
import com.jvv.customer.facade.user.result.FreezeAccountResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.core.util.TokenUtils;
import com.jvv.openapi.intergration.customer.user.FreezeAccountClient;
import com.jvv.openapi.service.customer.user.requset.FreezeAccountRequest;
import com.jvv.openapi.service.customer.user.response.FreezeAccountResponse;
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
@OpenApiService (name = "freezeAccount",desc = "更改用户冻结状态",responseType = ResponseTypeEnum.SYN)
public class FreezeAccountApiService extends AbstractApiService<FreezeAccountRequest,FreezeAccountResponse> {
	
	@Resource
	private FreezeAccountClient freezeAccountClient;
	@Resource
	private TokenUtils tokenUtils;
	
	@Override
	protected void doService (FreezeAccountRequest request, FreezeAccountResponse response) {
		FreezeAccountOrder order = new FreezeAccountOrder ();
		BeanUtils.copyProperties (request,order);
		String userId = tokenUtils.getUserIdByToken (request.getToken ());
		order.setUserId (userId);
		
		FreezeAccountResult result = freezeAccountClient.updateAccountState (order, request.getRemark ());
		response.setStatus (result.getStatus().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getMessage ());
		response.setCode (result.getCode ());
	}
}
