/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.persist.db.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 修订记录：
 * liubin 2015-07-30 15:59 创建
 */
public class ApiServiceManualDoc  extends AbstractDomain{
	
	private String serviceName;
	
	private String description;

	private String serviceNo;

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
