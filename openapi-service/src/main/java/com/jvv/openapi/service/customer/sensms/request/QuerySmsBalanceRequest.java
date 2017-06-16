/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.customer.sensms.request;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @date
 * @time
 */
public class QuerySmsBalanceRequest  extends ApiRequest {
	
	//短信通道
	@NotBlank
	@OpenApiField(desc = "smsChannel", constraint = "短信通道不能为空")
	private String smsChannel;
	
	public String getSmsChannel () {
		return smsChannel;
	}
	
	public void setSmsChannel (String smsChannel) {
		this.smsChannel = smsChannel;
	}
}
