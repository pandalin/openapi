/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.intergration.customer.sendsms;

import com.jvv.common.services.result.SimpleResult;
import com.jvv.customer.facade.sendsms.api.SendSmsApi;
import com.jvv.gateway.facade.sendsms.order.QueryBalanceOrder;
import com.jvv.gateway.facade.sendsms.order.SendSmsOrder;
import com.jvv.gateway.facade.sendsms.result.SendSmsResult;
import com.jvv.gateway.facade.sendsms.result.SmsBalanceResult;
import com.jvv.openapi.intergration.Client;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @date
 * @time
 */
@Component
public class SendSmsClient  extends Client {
	
	public SendSmsResult sendSms(SendSmsOrder order){
		SendSmsResult sendSmsResult= null;
		try {
			SendSmsApi api = getDubboClient (SendSmsApi.class);
			sendSmsResult = api.sendSms (order);
		} catch (Exception e) {
			e.printStackTrace ();
			sendSmsResult.setDescription ("调用业务系统异常");
		}
		return sendSmsResult;
	}
	public SmsBalanceResult queryBalance(QueryBalanceOrder order){
		com.jvv.gateway.facade.sendsms.api.SendSmsApi api = getDubboClient (com.jvv.gateway.facade.sendsms.api.SendSmsApi.class);
		return api.queryBalance (order);
	}
	
}
