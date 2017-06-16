/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.persist.db.domain;

/**
 * 修订记录：
 * liubin 2015-07-30 17:11 创建
 */
public class ApiSchemeServiceDoc extends AbstractDomain{

	public ApiSchemeServiceDoc(){}

	public ApiSchemeServiceDoc(String serviceNo){
		this.serviceNo = serviceNo;
	}

	private String  serviceNo;
	
	private String schemeId;
	
	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getSchemeId() {
		return this.schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}
}
