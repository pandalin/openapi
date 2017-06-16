/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2015 All Rights Reserved.
 */

package com.jvv.openapi.doc.persist.db.domain;

/**
 * 修订记录：
 * liubin 2015-07-30 17:11 创建
 */
public class ApiSchemeContent extends AbstractDomain {

	public ApiSchemeContent(){}

	public ApiSchemeContent(String content){
		this.content = content;
	}

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
