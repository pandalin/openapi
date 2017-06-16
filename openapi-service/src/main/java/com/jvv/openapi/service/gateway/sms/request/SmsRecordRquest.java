/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package com.jvv.openapi.service.gateway.sms.request;

import com.jvv.openapi.core.service.entity.ApiRequest;
import com.jvv.openapi.core.service.meta.OpenApiField;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @date 2017/3/22
 * @time 11:58
 */
public class SmsRecordRquest extends ApiRequest {
	
	@NotNull
	@OpenApiField(desc = "开始日期", constraint = "必填")
	private String beginDate;
	
	@NotNull
	@OpenApiField(desc = "结束日期", constraint = "必填")
	private String endDate;
	
	@NotNull
	@OpenApiField(desc = "渠道类型", constraint = "必填")
	private String channelType;
	
	public String getBeginDate () {
		return beginDate;
	}
	
	public void setBeginDate (String beginDate) {
		this.beginDate = beginDate;
	}
	
	public String getEndDate () {
		return endDate;
	}
	
	public void setEndDate (String endDate) {
		this.endDate = endDate;
	}
	
	public String getChannelType () {
		return channelType;
	}
	
	public void setChannelType (String channelType) {
		this.channelType = channelType;
	}
}
