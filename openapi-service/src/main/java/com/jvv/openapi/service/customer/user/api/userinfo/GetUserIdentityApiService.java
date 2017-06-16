/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.user.api.userinfo;

import com.jvv.customer.facade.user.order.UserParamOrder;
import com.jvv.customer.facade.user.result.UserParamResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.user.UserParamClient;
import com.jvv.openapi.service.customer.user.requset.UserParamRequest;
import com.jvv.openapi.service.customer.user.response.GetUserIdentityResponseData;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author Huangw
 * @date 2017/3/21
 * @time 15:48
 */
@OpenApiService(name = "getUserIdentityApiService", desc = "获取身份列表接口", responseType = ResponseTypeEnum.SYN)
public class GetUserIdentityApiService extends AbstractApiService<UserParamRequest, ApiResponse> {
	
	@Resource
	UserParamClient client;
	
	@Override
	protected void doService (UserParamRequest request, ApiResponse response) {
		UserParamOrder order = new UserParamOrder ();
		UserParamResult result;
		UserParamResult result2;
		order.setIsUse (1);
		order.setCode ("identity");
		//查得全部女士身份
		order.setLevel (1);
		result = client.query (order,0L,1000);
		//查得全部男士身份
		order.setLevel (0);
		result2 = client.query (order,0L,1000);
		
		GetUserIdentityResponseData data = new GetUserIdentityResponseData ();
		data.setGirList (result.getInfos ());
		data.setBoyList (result2.getInfos ());
		
		response.setStatus(result.getStatus().getCode());
		response.setMessage(result.getMessage());
		response.setDetailMessage(result.getMessage());
		response.setDatas (data);
	}
}
