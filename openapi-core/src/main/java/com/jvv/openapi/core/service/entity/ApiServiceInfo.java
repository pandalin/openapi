/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 - 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * turalyon@jinvovo.com 2015-12-22 22:03 创建
 *
 */
package com.jvv.openapi.core.service.entity;

import com.jvv.openapi.core.service.ApiConstants;
import com.jvv.openapi.core.service.enums.ProtocolsEnum;
import com.jvv.openapi.core.service.meta.OpenApiField;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author turalyon@jinvovo.com
 * @version V1.0
 * @Description:
 * @date 2015/12/22 22:03
 */

public abstract class ApiServiceInfo implements Serializable {

	@NotNull
	@Size(min = 16, max = 40)
	@OpenApiField(desc = "请求订单号", constraint = "订单号长度为16-48字节")
	private String orderNo;

	@NotNull
	@OpenApiField(desc = "商户ID", constraint = "必填,需要在merchant表中配置")
	@Size(min = 20, max = 20)
	private String partnerId;
	
	@NotNull
	@OpenApiField(desc = "Api服务名", constraint = "必填")
	@Size(min = 3, max = 40)
	private String service;
	
	@OpenApiField(desc = "服务版本", constraint = "非必填")
	private String version = ApiConstants.VERSION_DEFAULT;
	
	@OpenApiField(desc = "服务协议", constraint = "非必填")
	private String protocol = ProtocolsEnum.HTTP_POST.getCode();
	
	//	@NotNull
	//	@Size(min = 16, max = 40)
	//	@OpenApiField(desc = "商户唯一的请求订单号", constraint = "订单号长度为16-40字节")
	//	private String orderNo;
	
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getService() {
		return service;
	}
	
	public void setService(String service) {
		this.service = service;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getPartnerId() {
		return partnerId;
	}
	
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	
	public String getProtocol() {
		return protocol;
	}
	
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
