/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.sensms.api;

import com.alibaba.fastjson.JSONObject;
import com.jvv.gateway.facade.sendsms.order.SendSmsOrder;
import com.jvv.gateway.facade.sendsms.result.SendSmsResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.customer.sendsms.SendSmsClient;
import com.jvv.openapi.service.customer.sensms.request.SendSmsRequest;

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
@OpenApiService(name = "SendSms", desc = "发送验证类短信", responseType = ResponseTypeEnum.SYN)
public class SendSmsApiService extends AbstractApiService<SendSmsRequest,ApiResponse>{
	@Resource
	SendSmsClient sendSmsClient;
	
	@Override
	protected void doService (SendSmsRequest request, ApiResponse response) {
		
		SendSmsOrder order=JSONObject.parseObject (request.getJsonStr (),SendSmsOrder.class);
		order.setOrderNo (request.getOrderNo ());
		SendSmsResult result= sendSmsClient.sendSms (order);
		
		response.setStatus (result.getStatus ().getCode ());
		response.setDetailMessage (result.getStatus ().getMessage ());
		response.setMessage (result.getDescription ());
		response.setCode (result.getCode ());
	}
}
