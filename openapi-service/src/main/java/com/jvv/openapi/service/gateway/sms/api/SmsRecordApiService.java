/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.gateway.sms.api;

import com.jvv.gateway.facade.sendsms.info.SmsRecordInfo;
import com.jvv.gateway.facade.sendsms.result.SmsRecordResult;
import com.jvv.openapi.core.service.base.AbstractApiService;
import com.jvv.openapi.core.service.entity.ApiResponse;
import com.jvv.openapi.core.service.enums.ResponseTypeEnum;
import com.jvv.openapi.core.service.meta.OpenApiService;
import com.jvv.openapi.intergration.gateway.sms.SmsRecordClient;
import com.jvv.openapi.service.gateway.sms.request.SmsRecordRquest;
import com.jvv.openapi.service.gateway.sms.response.SmsRecordResponseData;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA
 * 〈统计渠道短信数量〉 <p>
 * 〈统计渠道短信数量〉
 *
 * @author linxm
 * @date 2017/3/22
 * @time 13:41
 */
@OpenApiService(name = "querySmsByChannel", desc = "统计渠道短信数量", responseType = ResponseTypeEnum.SYN)
public class SmsRecordApiService extends AbstractApiService<SmsRecordRquest,ApiResponse> {
	
	@Resource
	private SmsRecordClient smsRecordClient;
	
	@Override
	protected void doService (SmsRecordRquest request, ApiResponse response) {
		SmsRecordResult smsRecordResult = smsRecordClient.querySmsRecordByChannel (request.getBeginDate (), request.getEndDate (), request.getChannelType ());
		response.setStatus(smsRecordResult.getStatus().getCode());
		response.setMessage(smsRecordResult.getMessage());
		response.setDetailMessage(smsRecordResult.getMessage());
		
		SmsRecordInfo smsRecordInfo = smsRecordResult.getInfo ();
		if (smsRecordInfo != null) {
			SmsRecordResponseData recordResponseData = new SmsRecordResponseData();
			BeanUtils.copyProperties (smsRecordInfo,recordResponseData);
			response.setDatas (recordResponseData);
		}
	}
}
