/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * zhike 2015年12月24日 下午4:33:26 创建
 */
package com.jvv.openapi.doc.persist.db.domain;

/**
 *
 *
 * @author zhike@jinvovo.com
 *
 */

public class QueryServiceEntity {
	private String serviceNo;
	
	private String schemeId;
	
	private String schemeName;
	
	private String manualNote;
	
	private String note;
	
	private String serviceName;
	
	private String schemeType;
	
	public String getSchemeType() {
		return this.schemeType;
	}

	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}

	public String getServiceNo() {
		return this.serviceNo;
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
	
	public String getSchemeName() {
		return this.schemeName;
	}
	
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	
	public String getManualNote() {
		return this.manualNote;
	}
	
	public void setManualNote(String manualNote) {
		this.manualNote = manualNote;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getServiceName() {
		return this.serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
}
