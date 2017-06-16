/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.sensms.api;

import com.jvv.common.lang.beans.Copier;
import com.jvv.common.services.result.SimpleResult;
import com.jvv.gateway.facade.sendsms.order.QueryBalanceOrder;
import com.jvv.gateway.facade.sendsms.result.SmsBalanceResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.sendsms.SendSmsClient;
import com.jvv.openapi.service.customer.sensms.request.QuerySmsBalanceRequest;
import com.jvv.openapi.service.customer.sensms.response.SmsBalanceResponseData;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @date
 * @time
 */
@OpenApiService(name = "querySmsBalance", desc = "获取短信余量", responseType = ResponseTypeEnum.SYN)
public class QuerySmsBalanceService extends AbstractApiService<QuerySmsBalanceRequest,ApiResponse> {
	@Resource
	SendSmsClient sendSmsClient;
	
	@Override
	protected void doService (QuerySmsBalanceRequest request, ApiResponse response) {
		QueryBalanceOrder order=new QueryBalanceOrder ();
		Copier.copy (request,order);

		SmsBalanceResult result= sendSmsClient.queryBalance (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setMessage (result.getMessage ());
		response.setDetailMessage (result.getDescription ());
		response.setCode (result.getCode ());

		if (result.getInfo() != null) {
			SmsBalanceResponseData balanceResponseData = new SmsBalanceResponseData();
			balanceResponseData.setBalance(result.getInfo().getBalance());
			response.setDatas(balanceResponseData);
		}

	}
}
