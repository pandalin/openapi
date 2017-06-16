/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.persist.db.domain;

/**
 * 修订记录：
 * liubin 2015-08-04 15:36 创建
 */
public class ApiItemManualDoc extends AbstractDomain {
	private String manualNote;

	private String itemNo;

	private String manualDemo;

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getManualNote() {
		return manualNote;
	}

	public void setManualNote(String manualNote) {
		this.manualNote = manualNote;
	}

	public String getManualDemo() {
		return manualDemo;
	}

	public void setManualDemo(String manualDemo) {
		this.manualDemo = manualDemo;
	}
}
