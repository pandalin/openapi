/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * zhike 2015年11月19日 下午4:33:56 创建
 */
package com.jvv.openapi.doc.persist.db.domain;

/**
 *
 *
 * @author zhike@jinvovo.com
 *
 */

public class ApiServiceQuery {
	
	private String schemeName;
	
	private ApiServiceDoc apiServiceDoc;
	
	private String schemeId;

	public String getSchemeId() {
		return this.schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	public String getSchemeName() {
		return this.schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public ApiServiceDoc getApiServiceDoc() {
		return this.apiServiceDoc;
	}

	public void setApiServiceDoc(ApiServiceDoc apiServiceDoc) {
		this.apiServiceDoc = apiServiceDoc;
	}
}
