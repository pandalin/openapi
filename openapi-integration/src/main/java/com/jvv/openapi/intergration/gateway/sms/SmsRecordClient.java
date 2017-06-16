/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.gateway.sms;

import com.jvv.gateway.facade.sendsms.api.SmsRecordApi;
import com.jvv.gateway.facade.sendsms.order.SmsRecordOrder;
import com.jvv.gateway.facade.sendsms.result.SmsRecordResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈统计渠道短信〉 <p>
 * 〈统计渠道短信〉
 *
 * @author linxm
 * @date 2017/3/22
 * @time 13:43
 */
@Component("smsRecordClient")
public class SmsRecordClient extends Client {
	
	/**
	 * 统计渠道短信
	 * @param beginDate
	 * @param endDate
	 * @param channelType
	 * @return
	 */
	public SmsRecordResult querySmsRecordByChannel(String beginDate,String endDate,String channelType) {
		
		SmsRecordApi smsRecordApi = getDubboClient (SmsRecordApi.class);
		
		SmsRecordOrder smsRecordOrder = new SmsRecordOrder ();
		smsRecordOrder.setBeginDate (beginDate);
		smsRecordOrder.setEndDate (endDate);
		smsRecordOrder.setChannelType (channelType);
		return smsRecordApi.querySMSRecordByChannel (smsRecordOrder);
		
	}
}
